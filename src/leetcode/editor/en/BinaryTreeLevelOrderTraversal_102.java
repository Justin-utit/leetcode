package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
//leetcode submit region begin(Prohibit modification and deletion)
    /**
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
    public BinaryTreeLevelOrderTraversal_102(Integer[] nums) {
        this.nums = nums;
    }
    public BinaryTreeLevelOrderTraversal_102() {
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
        Solution solution = new BinaryTreeLevelOrderTraversal_102().new Solution();

        Integer[] nums =
                {5,
                        2,6,
                        1,4,null,7,
                        null,null,3,null,null,null,null,null};
        BinaryTreeLevelOrderTraversal_102 obj = new BinaryTreeLevelOrderTraversal_102(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.levelOrder(treeNode);

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            System.out.println(root); // 拿到模擬資料了

            List<List<Integer>> result = new ArrayList<>();

            if(root==null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root); // 放入根節點

            while (!queue.isEmpty()){ // 一輪一層


                List<Integer> currentLevel = new ArrayList<>();

                int size = queue.size(); // 該層有幾個節點
                for(int i = 0; i<size; i++){ // 一一取出該層的節點
                    TreeNode treeNode = queue.poll(); //

                    int currentVal = treeNode.val;
                    currentLevel.add(currentVal);

                    if(treeNode.left!=null)
                        queue.add(treeNode.left);
                    if(treeNode.right!=null)
                        queue.add(treeNode.right);
                }

                result.add(currentLevel);
//                System.out.println(treeNode.val);

            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
