package 剑指Offer.剑指Offer07重建二叉树;


public class Solution {
	//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = new TreeNode(preorder[0]);

		return null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
