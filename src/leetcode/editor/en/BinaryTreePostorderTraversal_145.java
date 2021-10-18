package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal_145().new Solution();



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
        public List<Integer> postorderTraversal(TreeNode root) {

            if(root==null)
                return list;

            recursive(root);

            return list;
        }

        public void recursive(TreeNode root) {

            if(root==null)
                return;

            recursive(root.left);
            recursive(root.right);
            list.add(root.val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
