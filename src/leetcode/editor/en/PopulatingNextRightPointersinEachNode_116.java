package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode_116 {
    public PopulatingNextRightPointersinEachNode_116(Integer[] nums) {
        this.nums = nums;
    }
    public PopulatingNextRightPointersinEachNode_116() {
    }
    private Integer[] nums;
    private Node root;
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
    public void buildtree () {
        if (this.nums.length < 0) return;
        if (this.nums[0] == null) return;

        // prepare Node instances
        Node[] nodes_tmp = new Node[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new Node(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            Node node = nodes_tmp[i];
            if (node == null) continue;

            if (i_left < this.nums.length) {
                node.left = nodes_tmp[i_left];
            }
            if (i_right < this.nums.length) {
                node.right = nodes_tmp[i_right];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersinEachNode_116().new Solution();

        Integer[] nums =
                {1,2,3,4,5,6,7};
        PopulatingNextRightPointersinEachNode_116 obj = new PopulatingNextRightPointersinEachNode_116(nums);
        obj.buildtree();
        Node treeNode = obj.root;


        solution.connect(treeNode);

    }


    class Solution {
        public Node connect(Node root) {

            if(root==null)
                return null;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i<size; i++){
                    Node currNode = queue.poll();
                    Node nextNode = queue.peek();
                    if(currNode!=null){
                        // System.out.printf(" %d->", currNode.val);

                        // 最後一個指null, 其他的就正常連下一個節點
                        if(i==size-1)
                            currNode.next = null;
                        else
                            currNode.next = nextNode;

//                        if(currNode.next!=null)
//                            System.out.print(currNode.next.val);
//                        else
//                            System.out.print("X");



                        // 放下一層的
                        if(currNode.left!=null)
                            queue.add(currNode.left);
                        if(currNode.right!=null)
                            queue.add(currNode.right);

                    }
                }

                System.out.println();
            }


            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}



















