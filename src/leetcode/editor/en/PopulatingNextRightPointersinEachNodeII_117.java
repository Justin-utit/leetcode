package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII_117 {

    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersinEachNodeII_117().new Solution();


    }
//leetcode submit region begin(Prohibit modification and deletion)
/**/
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    class Solution {
        public Node connect(Node root) {

            if(root==null)
                return root;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i< size; i++){

                    Node node = queue.poll();
                    Node nextNode = queue.peek();
                    if(node!=null){

                        if(i==size-1){
                            node.next = null;
                        }else {
                            node.next = nextNode;
                        }


                        if(node.left!=null)
                            queue.add(node.left);
                        if(node.right!=null)
                            queue.add(node.right);
                    }

                }
            }



            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




















