package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumAbsoluteDifferenceinBST_530 {
    public MinimumAbsoluteDifferenceinBST_530(Integer[] nums) {
        this.nums = nums;
    }
    public MinimumAbsoluteDifferenceinBST_530() {
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
        Solution solution = new MinimumAbsoluteDifferenceinBST_530().new Solution();
/*
						解答失败:
						测试用例:[5,3,6,2,4,null,null,1]
						测试结果:2
						期望结果:1
 */
        Integer[] nums =
                {5,3,6,2,4,null,null,1};
        MinimumAbsoluteDifferenceinBST_530 obj = new MinimumAbsoluteDifferenceinBST_530(nums);
        obj.buildtree();
        TreeNode treeNode = obj.root;


        solution.getMinimumDifference(treeNode);

    }
    class Solution {
        public int getMinimumDifference(TreeNode root) {

            if(root==null)
                return 0;

            List<Integer> list = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i<size; i++){
                    TreeNode treeNode = q.poll();
//                    System.out.println(treeNode.val);
                    list.add(treeNode.val);

                    if(treeNode!=null){
                        if(treeNode.left!=null)
                            q.add(treeNode.left);
                        if(treeNode.right!=null)
                            q.add(treeNode.right);


                    }
                }
            }



            int min = Integer.MAX_VALUE;
            for(int i = 0; i<list.size(); i++){ // 1 3 2
                for(int j = i+1; j<list.size(); j++){

                    int subtraction = Math.abs(list.get(j) - list.get(i));
                    if(subtraction<min)
                        min = subtraction;

                }
            }


            return min;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)
}



















