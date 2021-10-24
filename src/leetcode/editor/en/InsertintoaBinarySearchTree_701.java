package leetcode.editor.en;

public class InsertintoaBinarySearchTree_701 {
    public static void main(String[] args) {
        Solution solution = new InsertintoaBinarySearchTree_701().new Solution();


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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode treeNode = new TreeNode(val);
            if(root==null){
                return treeNode;
            }

            TreeNode currNode = root; // 這個動作必要，因為要 返回插入后二叉搜索树的根节点。
            while (true){
                int currVal = currNode.val;
                if(val>=currVal){
                    if(currNode.right!=null){
                        currNode = currNode.right;
                    } else {
                        currNode.right = treeNode;
                        break;
                    }
                } else {
                    if(currNode.left!=null){
                        currNode = currNode.left;
                    } else {
                        currNode.left = treeNode;
                        break;
                    }
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
















