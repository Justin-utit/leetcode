package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII_107 {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalII_107().new Solution();


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

/*
						解答失败:
						测试用例:[3,9,20,null,null,15,7]
						测试结果:[[],[15,7],[9,20],[3]]
						期望结果:[[15,7],[9,20],[3]]
 */

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> list = new ArrayList<>();
            if(root==null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                int queueSize = queue.size();

                List<Integer> currentLevel = new ArrayList<>();
                for(int i = 0; i<queueSize; i++){
                    TreeNode treeNode = queue.poll();

                    if(treeNode==null)
                        continue;

                    currentLevel.add(treeNode.val);

                    if(treeNode.left!=null)
                        queue.add(treeNode.left);
                    if(treeNode.right!=null)
                        queue.add(treeNode.right);

                }

                list.add(0,currentLevel);
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
