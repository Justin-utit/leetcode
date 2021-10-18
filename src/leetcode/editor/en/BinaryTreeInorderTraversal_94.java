package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal_94().new Solution();


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
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {

            if(root==null)
                return list;

            recursive(root);

            return list;
        }

        private void recursive(TreeNode root) {

            if(root==null)
                return;

            recursive(root.left);
            list.add(root.val);
            recursive(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
