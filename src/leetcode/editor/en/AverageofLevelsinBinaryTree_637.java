package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree_637 {


//leetcode submit region begin(Prohibit modification and deletion)
public AverageofLevelsinBinaryTree_637(Integer[] nums) {
    this.nums = nums;
}
    public AverageofLevelsinBinaryTree_637() {
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
        Solution solution = new AverageofLevelsinBinaryTree_637().new Solution();

        Integer[] nums =
                {3,9,20,null,null,15,7};
        AverageofLevelsinBinaryTree_637 obj = new AverageofLevelsinBinaryTree_637(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.averageOfLevels(treeNode);

    }
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {

            List<Double> list = new ArrayList<>();

            if(root==null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){

                double sum = 0d;

                int size = queue.size();
                for(int i = 0; i<size; i++){
                    // queue.poll(); // 沒東西回null
                    TreeNode currentNode = queue.poll(); // 沒東西直炸
                    if(currentNode!=null)
                        sum+=currentNode.val;
                    if(currentNode.left!=null)
                        queue.add(currentNode.left);
                    if(currentNode.right!=null)
                        queue.add(currentNode.right);

                }

                list.add(sum/size);

            }


            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
