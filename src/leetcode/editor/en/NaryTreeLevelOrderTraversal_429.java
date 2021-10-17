package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

            List<List<Integer>> list = new ArrayList<>();

            if(root==null)
                return list;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> subList = new ArrayList<>();
                for(int i = 0; i<size; i++){
                    Node currentNode = queue.poll(); // null if empty


                    if(currentNode!=null) {
                        subList.add(currentNode.val);
                        System.out.println(currentNode.val);
                        List<Node> children = currentNode.children;
                        for(Node node : children){
                            System.out.println(node);
                            queue.add(node);
                        }
                    }
                }
                list.add(subList);


            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}



















