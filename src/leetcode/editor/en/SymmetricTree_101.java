package leetcode.editor.en;

public class SymmetricTree_101 {

    public SymmetricTree_101(Integer[] nums) {
        this.nums = nums;
    }
    public SymmetricTree_101() {
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
        Solution solution = new SymmetricTree_101().new Solution();

        Integer[] nums =
                {1,2,2,null,3,null,3};
        SymmetricTree_101 obj = new SymmetricTree_101(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.isSymmetric(treeNode);

    }

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
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 						测试用例:[1,2,2,null,3,null,3]
     * 						测试结果:true
     * 						期望结果:false
     * 					1
     * 				2       2
     * 			null 3  null 3
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;

            return isSymmetric(root.left,root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {

            if(left==null||right==null)
                return left==right;

            // 左右兩邊子節點不同，就不行
            if(left.val!=right.val)
                return false;

            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}










