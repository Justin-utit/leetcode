package leetcode.editor.en;

import java.util.List;

public class BinaryTreeLevelOrderTraversal_樹的模擬資料 {
//leetcode submit region begin(Prohibit modification and deletion)

    public BinaryTreeLevelOrderTraversal_樹的模擬資料(Integer[] nums) {
        this.nums = nums;
    }
    public BinaryTreeLevelOrderTraversal_樹的模擬資料() {
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
        Solution solution = new BinaryTreeLevelOrderTraversal_樹的模擬資料().new Solution();

        Integer[] nums =
                {5,
                        2,6,
                        1,4,null,7,
                        null,null,3,null,null,null,null,null};
        BinaryTreeLevelOrderTraversal_樹的模擬資料 obj = new BinaryTreeLevelOrderTraversal_樹的模擬資料(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.levelOrder(treeNode);

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            System.out.println(root); // 拿到模擬資料了

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



/**
 * 原置於Begin之下
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */