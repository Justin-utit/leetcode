package leetcode.editor.en;

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements_203().new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(6);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        int target = 6;
        solution.removeElements(head,target);

    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /*
            输入：head = [1,2,6,3,4,5,6], val = 6
            输出：[1,2,3,4,5]
         */
        public ListNode removeElements(ListNode head, int val) {


            // 處理第一個節點的值就是val的情況
            while(head!=null && head.val==val){
                head = head.next;
            }

            ListNode currentNodeProxy = head; // 2
            // check(=if) if the next node is the node you want to remove
            // head = [2,6,3,4,5,6], val = 6
            while(currentNodeProxy!=null&&currentNodeProxy.next!=null){
                if(currentNodeProxy.next.val==val){
                    currentNodeProxy.next = currentNodeProxy.next.next;
                }else{
                    currentNodeProxy = currentNodeProxy.next;
                }
            }


            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


















