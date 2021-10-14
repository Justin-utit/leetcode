package leetcode.editor.en;

public class InvertBinaryTree_226 {

    public InvertBinaryTree_226(Integer[] nums) {
        this.nums = nums;
    }
    public InvertBinaryTree_226() {
    }
    private Integer[] nums;
    private InvertBinaryTree_226.TreeNode root;
    public class TreeNode {
        public InvertBinaryTree_226.TreeNode left;
        public InvertBinaryTree_226.TreeNode right;
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
        InvertBinaryTree_226.TreeNode[] nodes_tmp = new InvertBinaryTree_226.TreeNode[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new InvertBinaryTree_226.TreeNode(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            InvertBinaryTree_226.TreeNode node = nodes_tmp[i];
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
        InvertBinaryTree_226.Solution solution = new InvertBinaryTree_226().new Solution();

        Integer[] nums =
                {5,
                        2,6,
                        1,4,null,7,
                        null,null,3,null,null,null,null,null};
        InvertBinaryTree_226 obj = new InvertBinaryTree_226(nums);
        obj.buildtree();
        InvertBinaryTree_226.TreeNode treeNode = obj.root;


        solution.invertTree(treeNode);

    }

    class Solution {
        public TreeNode invertTree(TreeNode root) { // 轉小三角 (上點不動，下兩點交換)

            if(root==null)
                return root;

            TreeNode left = invertTree(root.left); // 轉小三角
            TreeNode right = invertTree(root.right); // 轉小三角
            root.left = right;
            root.right = left;

            return root;
        }
    }
}











