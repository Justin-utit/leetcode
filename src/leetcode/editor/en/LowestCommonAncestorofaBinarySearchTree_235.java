package leetcode.editor.en;

public class LowestCommonAncestorofaBinarySearchTree_235 {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorofaBinarySearchTree_235().new Solution();


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

            // dfs left
            if(root==null)
                return null;

            // this -> just return
            if(root==p||root==q)
                return root;

            root.left = lowestCommonAncestor(root.left,p,q);
            root.right = lowestCommonAncestor(root.right,p,q);

            // 雙，return this
            if(root.left!=null&&root.right!=null){
                return root;
            } else if(root.left==null&&root.right==null){
                return null;
            } else if(root.left!=null){
                return root.left;
            } else {
                return root.right;
            }
            // 1 , return 1
            // null return null

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
