package leetcode.editor.en;

public class SumofLeftLeaves_404 {
    public SumofLeftLeaves_404(Integer[] nums) {
        this.nums = nums;
    }
    public SumofLeftLeaves_404() {
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
        Solution solution = new SumofLeftLeaves_404().new Solution();

        Integer[] nums =
                {3,9,20,null,null,15,7};
        SumofLeftLeaves_404 obj = new SumofLeftLeaves_404(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.sumOfLeftLeaves(treeNode);

    }
    class Solution {



        public int sumOfLeftLeaves(TreeNode root) {

            if(root==null){
                return 0;
            }

            int sum = 0;

            // 先看左邊
            if(root.left!=null){
                if(root.left.left==null&&root.left.right==null){
                    sum+=root.left.val;
                } else {
                    sum+=sumOfLeftLeaves(root.left);
                }
            }

            // 左邊看完看右邊
            if(root.right!=null){
                if(root.right.left!=null||root.right.right!=null)
                    sum+=sumOfLeftLeaves(root.right);
            }


            return sum;
        }






    }
//leetcode submit region end(Prohibit modification and deletion)
}










