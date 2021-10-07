package leetcode.editor.en;

public class LinkedListCycle_141 {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycle_141().new Solution();

        ListNode headA = new ListNode(3); // 視作n0
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        headA.next = n1;
        n1.next = n2;
        n2.next = n3;

        solution.hasCycle(headA);

    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {

            // 有交集= 有Cycle

            ListNode slow_pointer = head;
            ListNode fast_pointer = head.next;

            while(slow_pointer!=fast_pointer){

                // reach the end and no come back around
                if(fast_pointer==null || fast_pointer.next==null){
                    return false;
                }

                slow_pointer = slow_pointer.next;
                fast_pointer = fast_pointer.next.next;

            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
















