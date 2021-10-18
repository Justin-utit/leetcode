package leetcode.editor.en;

import java.awt.event.WindowFocusListener;
import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree_110_2 {
    public BalancedBinaryTree_110_2(Integer[] nums) {
        this.nums = nums;
    }
    public BalancedBinaryTree_110_2() {
    }
    private Integer[] nums;
    private TreeNode root;
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(){}
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void buildtree () {
        if (this.nums.length < 0) return;
        if (this.nums[0] == null) return;

        // prepare Node instances
        TreeNode[] nodes_tmp = new TreeNode[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new TreeNode(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            TreeNode node = nodes_tmp[i];
            if (node == null) continue;

            if (i_left < this.nums.length) {
                node.left = nodes_tmp[i_left];
            }
            if (i_right < this.nums.length) {
                node.right = nodes_tmp[i_right];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree_110_2().new Solution();

        Integer[] nums =
                {3,9,20,null,null,15,7};
        BalancedBinaryTree_110_2 obj = new BalancedBinaryTree_110_2(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.isBalanced(treeNode);

    }
    class Solution {
        public boolean isBalanced(TreeNode root) {
            // the goal is to get the height of the node
            // 左子樹的高度 與 右子樹的高度 差為 0 or 1

            if(root==null)
                return true;

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            boolean balanced = Math.abs(leftHeight-rightHeight)<=1;

            boolean result = false;
            result = balanced && isBalanced(root.left) && isBalanced(root.right);

            return result;
        }

        private int getHeight(TreeNode root) {
            if(root==null) return 0;
            return Math.max( getHeight(root.left), getHeight(root.right) ) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}














