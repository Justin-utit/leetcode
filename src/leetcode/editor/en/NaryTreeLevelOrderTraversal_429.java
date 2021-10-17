package leetcode.editor.en;

import java.util.List;

public class NaryTreeLevelOrderTraversal_429 {

    public static void main(String[] args) {
        Solution solution = new NaryTreeLevelOrderTraversal_429().new Solution();



    }

//leetcode submit region begin(Prohibit modification and deletion)
/**/
// Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
