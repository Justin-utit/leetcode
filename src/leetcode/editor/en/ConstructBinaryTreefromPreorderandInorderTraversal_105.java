package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreefromPreorderandInorderTraversal_105().new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder,inorder);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // preorder
            // inorder
            int preorderSize = preorder.length;
            int inorderSize = inorder.length;
            Map<Integer,Integer> inorderMap = new HashMap<>();
            for(int i = 0; i<inorderSize; i++){
                inorderMap.put(inorder[i], i);
            }

            return buildTree(preorder,0,preorderSize-1, inorderMap,0,inorderSize-1);
        }

        private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                   Map<Integer, Integer> inorderMap, int inLeft, int inRight) {

            if(preLeft>preRight || inLeft>inRight){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preLeft]); // preorder的第一個必為root
            int rootIndex = inorderMap.get(root.val); // 找到 current tree root

            root.left = buildTree(preorder,preLeft+1, rootIndex-inLeft+preLeft, inorderMap, inLeft, rootIndex-1);
            root.right = buildTree(preorder,rootIndex-inLeft+preLeft+1, preRight, inorderMap, rootIndex+1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
















