package leetcode.editor.en;

public class IntersectionofTwoLinkedLists_160 {
    public static void main(String[] args) {
        Solution solution = new IntersectionofTwoLinkedLists_160().new Solution();

        ListNode headA = new ListNode(2); // 視作n0
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        headA.next = n1;
        n1.next = n2;

        ListNode headB = new ListNode(1);
        ListNode n3 = new ListNode(5);
        headB.next = n3;

        ListNode result = solution.getIntersectionNode(headA,headB);
        System.out.println(result);

    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if(headA==null || headB==null){
                return null;
            }

            ListNode aPointer = headA;
            ListNode bPointer = headB;
            //                    v -> return null;
            // 2 6 4    null 1 5 null 2 6 4
            // 1 5 null 2    6 4 null 1 5

            while(aPointer!=bPointer){

                if(aPointer==null){
                    aPointer = headB;
                } else {
                    aPointer = aPointer.next;
                }

                if(bPointer==null){
                    bPointer = headA;
                } else {
                    bPointer = bPointer.next;
                }
            }




            return aPointer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}























