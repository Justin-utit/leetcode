package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow_515 {

    public FindLargestValueinEachTreeRow_515(Integer[] nums) {
        this.nums = nums;
    }
    public FindLargestValueinEachTreeRow_515() {
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
        Solution solution = new FindLargestValueinEachTreeRow_515().new Solution();

        Integer[] nums =
                {0,-1};
        FindLargestValueinEachTreeRow_515 obj = new FindLargestValueinEachTreeRow_515(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.largestValues(treeNode);

    }
    class Solution {
        public List<Integer> largestValues(TreeNode root) {

            List<Integer> list = new ArrayList<>();

            if(root==null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();

                int max = Integer.MIN_VALUE;
                for(int i = 0; i<size; i++){
                    TreeNode currentNode = queue.poll();

                    if(currentNode!=null){
                        int val = currentNode.val;
                        if(val>max)
                            max = val;

                        if (currentNode.left!=null)
                            queue.add(currentNode.left);
                        if (currentNode.right!=null)
                            queue.add(currentNode.right);
                    }

                }

                list.add(max);


            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


















