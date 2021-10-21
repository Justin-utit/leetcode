package leetcode.editor.en;

import java.nio.file.Path;

public class PathSum_112 {

    public PathSum_112(Integer[] nums) {
        this.nums = nums;
    }
    public PathSum_112() {
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
        Solution solution = new PathSum_112().new Solution();

        Integer[] nums =
                {5,4,8,11,null,13,4,7,2,null,null,null,1};
        PathSum_112 obj = new PathSum_112(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.hasPathSum(treeNode,22);

    }
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root!=null)
                System.out.println(root.val);

            if(root==null){
                return false;
            } else if(root.left==null&&root.right==null&&targetSum-root.val==0){
                return true;
            } else {

                boolean test1 = hasPathSum(root.left, targetSum-root.val);
                boolean test2 = hasPathSum(root.right, targetSum-root.val);

                return test1 || test2; //
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
