package leetcode.editor.en;

public class ConvertSortedArraytoBinarySearchTree_108 {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArraytoBinarySearchTree_108().new Solution();


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
        public TreeNode sortedArrayToBST(int[] nums) {

            if(nums==null)
                return null;

            TreeNode treeNode = bst(nums,0,nums.length-1);

            return treeNode;
        }

        private TreeNode bst(int[] nums, int start, int end) {
            if(start>end)
                return null;

            int midPoint = start+ (end-start)/2;
            TreeNode root = new TreeNode(nums[midPoint]);

            root.left = bst(nums,start,midPoint-1);
            root.right = bst(nums,midPoint+1,end);

            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}


















