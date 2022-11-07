# [排序算法-堆排序（nlogN）](https://github.com/imtsingyun/LeetCode/issues/44)

### 堆排序（nlogN）
- 是对选择排序的一种优化

![](https://www.runoob.com/wp-content/uploads/2019/03/heapSort.gif)

```java
public class HeapSort {
    public static void main(String[] args) {
        Integer[] nums = Utils.generateArr(20, 20);
        sort(nums);
        Utils.printArr(nums);
    }
    
    private static void sort(Integer[] nums) {
        // 1. 批量建堆
        buildHeap(nums);
        int heapSize = nums.length;
        while (heapSize > 1) {
            --heapSize;
            Utils.swap(nums, 0, heapSize);
            shiftDown2(nums, heapSize, 0);
        }
    }

    private static void buildHeap(Integer[] nums) {
        int lastNode = nums.length - 1;     // 最后一个节点
        int parent = (lastNode - 1) / 2;    // 最后一个节点的父节点
        for (int i = parent; i >= 0; i--) {
            shiftDown2(nums, nums.length, i);
        }
    }

    /**
     * 自下而上的 下滤
     * @param nums 数组
     * @param n    数组中元素的个数
     * @param i    需要进行 下滤 的节点
     */
    private static void shiftDown1(Integer[] nums, int n, int i) {
        int tmp = nums[i];
        // 叶子节点没有子节点所以不需要下滤
        // 所以，第 i 个需要下滤的节点至少需要有一个子节点，而如果只有一个子节点那这个节点必定是左子节点
        // 第 i 个元素的左子节点是 (i*2+1)，< n 表示存在于数组中
        while (i * 2 + 1 < n) {
            int childNode = i * 2 + 1;      // 默认取左子节点，因为不可能出现存在右子节点而不存在左子节点的情况
            int rightNode = i * 2 + 2;

            if (rightNode < n && nums[rightNode] > nums[childNode]) {
                childNode = rightNode;
            }
            // 父节点最大
            if (tmp >= nums[childNode]) {
                break;
            }
            nums[i] = nums[childNode];
            i = childNode;
        }
        nums[i] = tmp;
    }

    private static void shiftDown2(Integer[] nums, int n, int i) {
        int tmp = nums[i];
        // 非叶子节点的数量
        int half = n / 2;
        while (i < half) {
            int childNode = i * 2 + 1;
            int rightNode = i * 2 + 2;

            if (rightNode < n && nums[rightNode] > nums[childNode]) {
                childNode = rightNode;
            }
            if (tmp > nums[childNode]) {
                break;
            }
            nums[i] = nums[childNode];
            i = childNode;
        }
        nums[i] = tmp;
    }
}
```