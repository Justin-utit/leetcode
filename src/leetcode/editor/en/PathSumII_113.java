package leetcode.editor.en;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public static void main(String[] args) {
        Solution solution = new PathSumII_113().new Solution();


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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            List<List<Integer>> paths = new ArrayList<>();

            findPaths(root,targetSum,new ArrayList<Integer>(),paths);

            return paths;
        }

        private void findPaths(TreeNode root, int targetSum, ArrayList<Integer> current, List<List<Integer>> paths) {
            if(root==null)
                return;

            current.add(root.val);
            if(root.val==targetSum && root.left==null && root.right==null){
                paths.add(current);
                return;
            } else {
                findPaths(root.left, targetSum-root.val, new ArrayList<>(current), paths);
                findPaths(root.right, targetSum-root.val, new ArrayList<>(current), paths);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}















