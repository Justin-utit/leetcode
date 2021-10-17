package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree_104 {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthofBinaryTree_104().new Solution();


    }
//leetcode submit region begin(Prohibit modification and deletion)
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
}
    class Solution {
        public int maxDepth(TreeNode root) {

            if(root==null)
                return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int counter = 0;
            while (!queue.isEmpty()){
                counter++;
                int size = queue.size();
                for(int i = 0 ; i<size; i++){
                    TreeNode treeNode = queue.poll();
                    if(treeNode!=null){

                        if(treeNode.left!=null)
                            queue.add(treeNode.left);
                        if(treeNode.right!=null)
                            queue.add(treeNode.right);
                    }

                }
            }

            return counter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
















