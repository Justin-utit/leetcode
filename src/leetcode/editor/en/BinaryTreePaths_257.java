package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public BinaryTreePaths_257(Integer[] nums) {
        this.nums = nums;
    }
    public BinaryTreePaths_257() {
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
        Solution solution = new BinaryTreePaths_257().new Solution();

        Integer[] nums =
                {1,2,3,null,5};
        BinaryTreePaths_257 obj = new BinaryTreePaths_257(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.binaryTreePaths(treeNode);

    }
    class Solution {


        public List<String> binaryTreePaths(TreeNode root) {

            List<String> paths = new ArrayList<>();

            if(root==null)
                return paths;

            dfs(root, "", paths);


            return paths;
        }

        private void dfs(TreeNode root, String path, List<String> paths) {
            path += root.val;

            if(root.left==null&&root.right==null){
                paths.add(path);
                return;
            }

            if(root.left!=null)
                dfs(root.left, path+"->",paths);
            if(root.right!=null)
                dfs(root.right, path+"->",paths);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}













