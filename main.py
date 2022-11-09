# -*- coding: utf-8 -*-
import argparse
import os
import re

from marko.ext.gfm import gfm as marko
from github import Github
from feedgen.feed import FeedGenerator
from lxml.etree import CDATA

MD_HEAD = """## Leetcode 笔记
本项目是基于 [@yihong0618](https://github.com/yihong0618) 的开源项目 [yihong0618/gitblog](https://github.com/yihong0618/gitblog) 创建而成 \n
[🈯️ Easy](https://github.com/imtsingyun/LeetCode#easy)   [🈚️ Medium](https://github.com/imtsingyun/LeetCode#medium)   [🈲 Hard](https://github.com/imtsingyun/LeetCode#hard)
\n
### 常用解题方法总结：[Summary](https://github.com/imtsingyun/LeetCode/blob/master/SUMMARY.md)
\n
### Issue Labels [配置文件 labels.yml](https://github.com/imtsingyun/LeetCode/tree/master/.github/config/labels.yml)
"""

BACKUP_DIR = "BACKUP"
ANCHOR_NUMBER = 15
TOP_ISSUES_LABELS = ["Top"]
TODO_ISSUES_LABELS = ["TODO"]
FRIENDS_LABELS = ["Friends"]
IGNORE_LABELS = FRIENDS_LABELS + TOP_ISSUES_LABELS + TODO_ISSUES_LABELS

FRIENDS_TABLE_HEAD = "| Name | Link | Desc | \n | ---- | ---- | ---- |\n"
FRIENDS_TABLE_TEMPLATE = "| {name} | {link} | {desc} |\n"
FRIENDS_INFO_DICT = {
    "名字": "",
    "链接": "",
    "描述": "",
}


def get_me(user):
    return user.get_user().login


def is_me(issue, me):
    return issue.user.login == me


def is_hearted_by_me(comment, me):
    reactions = list(comment.get_reactions())
    for r in reactions:
        if r.content == "heart" and r.user.login == me:
            return True
    return False


def _make_friend_table_string(s):
    info_dict = FRIENDS_INFO_DICT.copy()
    try:
        string_list = s.splitlines()
        # drop empty line
        string_list = [l for l in string_list if l and not l.isspace()]
        for l in string_list:
            string_info_list = re.split("：", l)
            if len(string_info_list) < 2:
                continue
            info_dict[string_info_list[0]] = string_info_list[1]
        return FRIENDS_TABLE_TEMPLATE.format(
            name=info_dict["名字"], link=info_dict["链接"], desc=info_dict["描述"]
        )
    except Exception as e:
        print(str(e))
        return


# help to covert xml vaild string
def _valid_xml_char_ordinal(c):
    codepoint = ord(c)
    # conditions ordered by presumed frequency
    return (
        0x20 <= codepoint <= 0xD7FF
        or codepoint in (0x9, 0xA, 0xD)
        or 0xE000 <= codepoint <= 0xFFFD
        or 0x10000 <= codepoint <= 0x10FFFF
    )


def format_time(time):
    return str(time)[:10]


def login(token):
    return Github(token)


def get_repo(user: Github, repo: str):
    return user.get_repo(repo)


def parse_TODO(issue):
    body = issue.body.splitlines()
    todo_undone = [l for l in body if l.startswith("- [ ] ")]
    todo_done = [l for l in body if l.startswith("- [x] ")]
    # just add info all done
    if not todo_undone:
        return f"[{issue.title}]({issue.html_url})", []
    return (
        f"[{issue.title}]({issue.html_url})--{len(todo_undone)} jobs to do--{len(todo_done)} jobs done",
        todo_done + todo_undone,
    )


def get_top_issues(repo):
    return repo.get_issues(labels=TOP_ISSUES_LABELS)


def get_todo_issues(repo):
    return repo.get_issues(labels=TODO_ISSUES_LABELS)


def get_repo_labels(repo):
    return [l for l in repo.get_labels()]


def get_issues_from_label(repo, label):
    return repo.get_issues(labels=(label,))


def add_issue_info(issue, md):
    time = format_time(issue.created_at)
    # 难度 0easy, 1medium, 2hard
    difficulty = -1
    for label in issue.labels:
        if "Easy" in label.name:
            difficulty = 0
        elif "Medium" in label.name:
            difficulty = 1
        elif "Hard" in label.name: 
            difficulty = 2
    
    if difficulty == -1:
        md.write(f"- [{issue.title}]({issue.html_url}) {time}\n")
    elif difficulty == 0:
        md.write(f"- 🈯 [{issue.title}]({issue.html_url}) {time}\n")
    elif difficulty == 1:
        md.write(f"- 🈚️ [{issue.title}]({issue.html_url}) {time}\n")
    elif difficulty == 2:
        md.write(f"- 🈲 [{issue.title}]({issue.html_url}) {time}\n")


def add_md_todo(repo, md, me):
    todo_issues = list(get_todo_issues(repo))
    if not TODO_ISSUES_LABELS or not todo_issues:
        return
    with open(md, "a+", encoding="utf-8") as md:
        md.write("## TODO（" + str(len(todo_issues)) + "）\n")
        for issue in todo_issues:
            if is_me(issue, me):
                todo_title, todo_list = parse_TODO(issue)                
                # 难度 0easy, 1medium, 2hard
                difficulty = -1
                for label in issue.labels:
                    if "Easy" in label.name:
                        difficulty = 0
                    elif "Medium" in label.name:
                        difficulty = 1
                    elif "Hard" in label.name: 
                        difficulty = 2
                if difficulty == -1:
                    md.write("- " + todo_title + "\n")
                elif difficulty == 0:
                    md.write("- 🈯 " + todo_title + "\n")
                elif difficulty == 1:
                    md.write("- 🈚️ " + todo_title + "\n")
                elif difficulty == 2:
                    md.write("- 🈲 " + todo_title + "\n")
                for t in todo_list:
                    md.write(t + "\n")
                # new line

def add_md_top(repo, md, me):
    top_issues = list(get_top_issues(repo))
    if not TOP_ISSUES_LABELS or not top_issues:
        return
    with open(md, "a+", encoding="utf-8") as md:
        md.write("## 置顶文章\n")
        for issue in top_issues:
            if is_me(issue, me):
                add_issue_info(issue, md)


def add_md_firends(repo, md, me):
    s = FRIENDS_TABLE_HEAD
    friends_issues = list(repo.get_issues(labels=FRIENDS_LABELS))
    for issue in friends_issues:
        for comment in issue.get_comments():
            if is_hearted_by_me(comment, me):
                try:
                    s += _make_friend_table_string(comment.body)
                except Exception as e:
                    print(str(e))
                    pass
    #with open(md, "a+", encoding="utf-8") as md:
       # md.write("## 友情链接\n")
       # md.write(s)


def add_md_recent(repo, md, me, limit=20):
    print("最近更新")
    count = 0
    with open(md, "a+", encoding="utf-8") as md:
        # one the issue that only one issue and delete (pyGitHub raise an exception)
        try:
            md.write("## 最近更新（" + limit + "）\n")
            print(repo.get_issues()))
            for issue in repo.get_issues():
                isTodo = False
                for label in issue.labels:
                    if label.name == 'TODO':
                        isTodo = True
                if is_me(issue, me) and isTodo==False:
                    print(issue.labels)
                    if count == limit:
                        md.write("<details><summary>显示更多</summary>\n")
                        md.write("\n")
                    add_issue_info(issue, md)
                    count += 1
                    if count >= limit:
                       break
            #if count > limit:
            #    md.write("</details>\n")
            #    md.write('\n')
        except:
            return


def add_md_header(md, repo_name):
    with open(md, "w", encoding="utf-8") as md:
        md.write(MD_HEAD.format(repo_name=repo_name))


def add_md_label(repo, md, me):
    labels = get_repo_labels(repo)

    # sort lables by description info if it exists, otherwise sort by name, 
    # for example, we can let the description start with a number (1#Java, 2#Docker, 3#K8s, etc.)
    labels = sorted(labels, key=lambda x: (x.description is None, x.description == "", x.description, x.name))

    with open(md, "a+", encoding="utf-8") as md:
        for label in labels:
            # print(label.name + ", " + label.description)
            # we don't need add top label again
            if label.name in IGNORE_LABELS:
                continue
            issues = get_issues_from_label(repo, label)
            if issues.totalCount:
                md.write("## " + label.name + "（" + str(issues.totalCount) + "）\n")
                issues = sorted(issues, key=lambda x: x.created_at, reverse=True)
            i = 0
            for issue in issues:
                if not issue:
                    continue
                if is_me(issue, me):
                    if i == ANCHOR_NUMBER:
                        md.write("<details><summary>显示更多</summary>\n")
                        md.write("\n")
                    add_issue_info(issue, md)
                    i += 1
            if i > ANCHOR_NUMBER:
                md.write("</details>\n")
                md.write("\n")


def get_to_generate_issues(repo, dir_name, issue_number=None):
    md_files = os.listdir(dir_name)
    generated_issues_numbers = [
        int(i.split("_")[0]) for i in md_files if i.split("_")[0].isdigit()
    ]
    to_generate_issues = [
        i
        for i in list(repo.get_issues())
        if int(i.number) not in generated_issues_numbers
    ]
    if issue_number:
        to_generate_issues.append(repo.get_issue(int(issue_number)))
    return to_generate_issues


def generate_rss_feed(repo, filename, me):
    generator = FeedGenerator()
    generator.id(repo.html_url)
    generator.title(f"RSS feed of {repo.owner.login}'s {repo.name}")
    generator.author(
        {"name": os.getenv("GITHUB_NAME"), "email": os.getenv("GITHUB_EMAIL")}
    )
    generator.link(href=repo.html_url)
    generator.link(
        href=f"https://raw.githubusercontent.com/{repo.full_name}/master/{filename}",
        rel="self",
    )
    for issue in repo.get_issues():
        if not issue.body or not is_me(issue, me) or issue.pull_request:
            continue
        item = generator.add_entry(order="append")
        item.id(issue.html_url)
        item.link(href=issue.html_url)
        item.title(issue.title)
        item.published(issue.created_at.strftime("%Y-%m-%dT%H:%M:%SZ"))
        for label in issue.labels:
            item.category({"term": label.name})
        body = "".join(c for c in issue.body if _valid_xml_char_ordinal(c))
        item.content(CDATA(marko.convert(body)), type="html")
    generator.atom_file(filename)


def main(token, repo_name, issue_number=None, dir_name=BACKUP_DIR):
    user = login(token)
    me = get_me(user)
    repo = get_repo(user, repo_name)
    # add to readme one by one, change order here
    add_md_header("README.md", repo_name)
    for func in [add_md_todo, add_md_firends, add_md_top, add_md_recent, add_md_label]:
        func(repo, "README.md", me)

    generate_rss_feed(repo, "feed.xml", me)
    to_generate_issues = get_to_generate_issues(repo, dir_name, issue_number)

    # save md files to backup folder
    for issue in to_generate_issues:
        save_issue(issue, me, dir_name)


def save_issue(issue, me, dir_name=BACKUP_DIR):
    md_name = os.path.join(
        dir_name, f"{issue.number}_{issue.title.replace(' ', '.')}.md"
    )
    with open(md_name, "w") as f:
        f.write(f"# [{issue.title}]({issue.html_url})\n\n")
        if issue.body is not None:
            f.write(issue.body)
        if issue.comments:
            for c in issue.get_comments():
                if is_me(c, me):
                    f.write("\n\n---\n\n")
                    f.write(c.body)


if __name__ == "__main__":
    if not os.path.exists(BACKUP_DIR):
        os.mkdir(BACKUP_DIR)
    parser = argparse.ArgumentParser()
    parser.add_argument("github_token", help="github_token")
    parser.add_argument("repo_name", help="repo_name")
    parser.add_argument(
        "--issue_number", help="issue_number", default=None, required=False
    )
    options = parser.parse_args()
    main(options.github_token, options.repo_name, options.issue_number)
