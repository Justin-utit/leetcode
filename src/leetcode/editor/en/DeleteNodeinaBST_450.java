package leetcode.editor.en;

public class DeleteNodeinaBST_450 {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeinaBST_450().new Solution();


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
        public TreeNode deleteNode(TreeNode root, int key) {

            if(root==null)
                return root;

            if(key>root.val){
                root.right = deleteNode(root.right,key);
            } else if(key< root.val){
                root.left = deleteNode(root.left,key);
            } else { // 找到點了 root.val == key

                if(root.left==null&&root.right==null) { // 沒子節，回null
                    return null;
                } else if(root.left==null&&root.right!=null){ // 單右子節有，回右子節點
                    return root.right;
                } else if(root.right==null&&root.left!=null){ // 單左子節有，回左子節點
                    return root.left;
                } else { // 雙子節有，
                    // 1 找右樹最小的節點
                    TreeNode minNode = findMin(root.right);
                    // 2 跟當前節 swap (是換裡面的值)
                    swapNode(root,minNode);
                    // 3 當前節點的右，接到 deleteNode的回傳值 (右樹的root)
                    TreeNode rTreeRoot = deleteNode(root.right,key);
                    if(root.right!=null){
                        root.right = rTreeRoot;
                    }
                }

            }

            return root;
        }

        // 注意，這裡只能換值
        private void swapNode(TreeNode root, TreeNode minNode) {
            // 換指標行不通
//		TreeNode temp = root;
//		root = minNode;
//		minNode = temp;
            int temp = root.val;
            root.val = minNode.val;
            minNode.val = temp;
        }

        private TreeNode findMin(TreeNode root) {
            while (root.left!=null){
                root = root.left;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
























