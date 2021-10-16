package leetcode.editor.en;

public class ValidateBinarySearchTree_98_1 {

    public ValidateBinarySearchTree_98_1(Integer[] nums) {
        this.nums = nums;
    }
    public ValidateBinarySearchTree_98_1() {
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
        Solution solution = new ValidateBinarySearchTree_98_1().new Solution();

        Integer[] nums =
                {5,1,4,null,null,3,6};
        ValidateBinarySearchTree_98_1 obj = new ValidateBinarySearchTree_98_1(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.isValidBST(treeNode);

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /*
    BST的兩個要求
    1 節點值 < 右節點值; 節點值 > 左節點值
    2.1 所以找出右節點中最小的，來跟節點比較，若右節點中最小 > 節點 -> ok
    2.2 所以找出左節點中最大的，來跟節點比較，若左節點中最大 < 節點 -> ok
    3 不能有重複的節點

    每一個子三角，都要符合左小右大的規定
     */

    class Solution {
        public boolean isValidBST(TreeNode root) {

            if(root==null)
                return true;

            return isValidBSTRecursive(root);
        }
        /*
                      5
                1          4
           null   null   3   6
         */
        private boolean isValidBSTRecursive(TreeNode root) {
            if(root==null) return true; // 遇到null回頭

            boolean result = true;

            // main logic
            int rootVal = root.val;
            // 最大的左節點
            TreeNode leftMax = getMax(root.left);
            if(leftMax!=null && rootVal<=leftMax.val)
                result = false;

            // 最小的右節點
            TreeNode rightMin = getMin(root.right);
            if(rightMin!=null && rootVal>=rightMin.val)
                result = false;

            if(result==false)
                return result;

            // DFS left 遍歷
            // pre-order
            boolean res1 = isValidBSTRecursive(root.left); // 左邊走到底
            // in-order
            boolean res2 = isValidBSTRecursive(root.right);
            // post-order

            if(res1==false||res2==false)
                result = false;

            return result;
        }
        private TreeNode getMax(TreeNode root) {
            if(root==null) return null;
            while(root.right!=null){
                root = root.right;
            }
            return root;
        }
        private TreeNode getMin(TreeNode root) {
            if(root==null) return null;
            while(root.left!=null){
                root = root.left;
            }
            return root;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)
}




















