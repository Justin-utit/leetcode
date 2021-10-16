package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public BinaryTreeRightSideView_199(Integer[] nums) {
        this.nums = nums;
    }
    public BinaryTreeRightSideView_199() {
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
        Solution solution = new BinaryTreeRightSideView_199().new Solution();

        // 					测试用例:[1,2,3,null,5,null,4]
        Integer[] nums =
                {1,2,3,null,5,null,4};
        BinaryTreeRightSideView_199 obj = new BinaryTreeRightSideView_199(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.rightSideView(treeNode);

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /*
    top to bottom -> 透過這一題，可以學會BFS的走法。
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> list = new ArrayList<>();

            if(root == null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i<size; i++){
                    TreeNode treeNode = queue.remove();
                    if(i==size-1)
                        list.add(treeNode.val);

                    if(treeNode.left!=null)
                        queue.add(treeNode.left);
                    if(treeNode.right!=null)
                        queue.add(treeNode.right);
                }
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
