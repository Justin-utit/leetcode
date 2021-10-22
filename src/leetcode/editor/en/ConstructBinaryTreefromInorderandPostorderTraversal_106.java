package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreefromInorderandPostorderTraversal_106().new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        solution.buildTree(inorder, postorder);

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // preorder
            // inorder
            int postorderSize = postorder.length;
            int inorderSize = inorder.length;
            Map<Integer,Integer> inorderMap = new HashMap<>();
            for(int i = 0; i<inorderSize; i++){
                inorderMap.put(inorder[i], i);
            }

            TreeNode tr = buildTree(postorder,0,postorder.length-1, inorderMap,0,inorderSize-1);

            return tr;
        }

        private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                Map<Integer, Integer> inorderMap, int inLeft, int inRight) {

            if(postLeft>postRight || inLeft>inRight){
                return null;
            }

            TreeNode root = new TreeNode(postorder[postRight]); // preorder的第一個必為root
            int rootIndex = inorderMap.get(root.val); // 找到 current tree root

            int numsLeft = rootIndex-inLeft; // 左長度

            root.left = buildTree(postorder, postLeft, postLeft+numsLeft-1, inorderMap, inLeft, rootIndex-1);

            root.right = buildTree(postorder, postLeft+numsLeft, postRight-1, inorderMap, rootIndex+1, inRight);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
