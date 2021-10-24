package leetcode.editor.en;

public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees_617().new Solution();


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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

            if(root1==null)
                return root2;
            if(root2==null)
                return root1;

            int v1 = root1.val;
            int v2 = root2.val;
            root1.val = v1+v2;

            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);


            return root1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}












