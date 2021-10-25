package leetcode.editor.en;

public class TrimaBinarySearchTree_669 {
    public static void main(String[] args) {
        Solution solution = new TrimaBinarySearchTree_669().new Solution();


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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root==null)
                return null;

            if(root.val<low){
                return trimBST(root.right,low,high);
            } else if (root.val>high){
                return trimBST(root.left, low,high);
            } else {
                root.left = trimBST(root.left,low,high);
                root.right = trimBST(root.right,low,high);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}











