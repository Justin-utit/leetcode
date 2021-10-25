package leetcode.editor.en;

public class ConvertBSTtoGreaterTree_538 {
    public static void main(String[] args) {
        Solution solution = new ConvertBSTtoGreaterTree_538().new Solution();


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
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if(root==null)
                return null;

            convertBST(root.right);

            sum += root.val;
            root.val = sum;

            convertBST(root.left);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
