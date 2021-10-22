package leetcode.editor.en;

import java.util.Arrays;

public class MaximumBinaryTree_564 {

    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree_564().new Solution();
        int[] nums = {3,2,1,6,0,5};
        solution.constructMaximumBinaryTree(nums);

    }
//leetcode submit region begin(Prohibit modification and deletion)
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
}
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {


            TreeNode treeNode = dfs(nums);

            return treeNode;
        }

        private TreeNode dfs(int[] nums) {

            if (nums.length==0)
                return null;

            int max = Integer.MIN_VALUE;
            int nodeIndex = 0;
            for(int i = 0; i<nums.length; i++){
                int currNum = nums[i];
                if(currNum>max) {
                    max = currNum;
                    nodeIndex = i;
                }
            }

            TreeNode treeNode = new TreeNode(max);

            int leftSize = nodeIndex-0; // 3
            int rightSize = nums.length-nodeIndex-1; // 2
            int[] leftArr = new int[leftSize];
            int[] rightArr = new int[rightSize];
            int pos = 0;
            for(int i = 0; i<leftSize; i++){
                leftArr[i] = nums[i];
            }
            for(int i = nodeIndex+1; i<nums.length; i++){
                rightArr[pos] = nums[i];
                pos++;
            }

            System.out.println();

            treeNode.left = dfs(leftArr);
            treeNode.right = dfs(rightArr);


            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
