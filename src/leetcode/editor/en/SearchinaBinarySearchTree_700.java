package leetcode.editor.en;

public class SearchinaBinarySearchTree_700 {
    public SearchinaBinarySearchTree_700(Integer[] nums) {
        this.nums = nums;
    }
    public SearchinaBinarySearchTree_700() {
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
        Solution solution = new SearchinaBinarySearchTree_700().new Solution();

        Integer[] nums =
                {4,2,7,1,3};
        SearchinaBinarySearchTree_700 obj = new SearchinaBinarySearchTree_700(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.searchBST(treeNode,2);

    }
    class Solution {

        TreeNode treeNode = null;

        public TreeNode searchBST(TreeNode root, int val) {

            if(root==null)
                return null;

            dfs(root,val);

            return treeNode;
        }

        private void dfs(TreeNode root, int val) {

            if(root==null)
                return;

            System.out.println(root.val);
            if(root.val==val)
                treeNode = root;

            dfs(root.left,val);
            dfs(root.right,val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


















