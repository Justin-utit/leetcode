package leetcode.editor.en;

public class LowestCommonAncestorofaBinaryTree_236 {

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorofaBinaryTree_236().new Solution();


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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {




            // dfs return case
            if(root==null)
                return null;

            // 自己就是了，就回傳自己
            if(root==p || root==q)
                return root;

            // dfs left
            root.left = lowestCommonAncestor(root.left, p, q);
            root.right = lowestCommonAncestor(root.right, p, q);


            if(root.left!=null && root.right!=null) // 當前node，左右都有node，就return當前node
                return root;
            else if(root.left==null && root.right==null) // 當前node，左右邊都null，就return null
                return null;
            else if(root.left!=null) // 當前node，只有一邊有node，就return該node
                return root.left;
            else
                return root.right;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
