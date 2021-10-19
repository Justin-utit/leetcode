package leetcode.editor.en;

public class SameTree_100 {
    public static void main(String[] args) {
        Solution solution = new SameTree_100().new Solution();


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
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if(p==null && q==null){
                return true;
            } else if(p==null||q==null){
                return false;
            } else if(p.val!=q.val){
                return false;
            } else {

                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

            }


        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
