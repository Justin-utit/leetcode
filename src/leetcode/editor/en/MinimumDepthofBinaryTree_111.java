package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree_111 {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthofBinaryTree_111().new Solution();


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
        public int minDepth(TreeNode root) {
            // use BFS find leaf node (node with no children), then return the depth

            if(root==null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int counter = 0;
            while (!queue.isEmpty()){
                counter++;
                int size = queue.size();
                for(int i = 0 ; i < size ; i++){
                    TreeNode treeNode = queue.poll();
                    if(treeNode!=null){
                        if(treeNode.left==null && treeNode.right==null)
                            return counter;

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
















