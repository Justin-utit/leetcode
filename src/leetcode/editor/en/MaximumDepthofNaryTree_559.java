package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree_559 {

    public static void main(String[] args) {
        Solution solution = new MaximumDepthofNaryTree_559().new Solution();


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
};


    class Solution {
        public int maxDepth(Node root) {

            if(root==null)
                return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int counter = 0;
            while(!queue.isEmpty()){
                counter++;
                int size = queue.size();
                for(int i = 0 ; i< size; i++){
                    Node node = queue.poll();
                    if(node !=null){
                        if(node.children!=null){
                            for(Node subNode : node.children){
                                if(subNode!=null){
                                    queue.add(subNode);
                                }
                            }
                        }
                    }
                }


            }

            return counter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












