package leetcode.editor.en;

import java.util.LinkedList;

public class LinkedListCycleII_142 {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleII_142().new Solution();

        ListNode headA = new ListNode(3); // 視作n0
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        headA.next = n1;
        n1.next = n2;
        n2.next = n3;

        solution.detectCycle(headA);

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
        public ListNode detectCycle(ListNode head) {

            // 一樣用pointer應該可以
            System.out.println(head);



            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}












