package leetcode.editor.en;

public class RemoveNthNodeFromEndofList_19 {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndofList_19().new Solution();
        ListNode head = new ListNode(0); // 視作n0
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
        head.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        ListNode listNode = solution.removeNthFromEnd(head,2);
        System.out.println(listNode);
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
        // 獨立完成中級
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 至少會有一個node, n也最少會有1

            if(head.next==null&&n==1)
                return null;

            // 0 1
            // n = 2
            // 1

            // total = 2
            // n = 2
            // size = 2-2 = 0

            ListNode curr = head;
            int counter = 0;
            while (curr!=null&&curr.next!=null){
                curr = curr.next;
                counter++;
            }

            int size = counter+1;
            int index = (size-n)-1; // 1

            // 0 1
            // n = 2
            // 1

            // size 2
            // n 2
            // index -1

            if(size==n){ // 要移除head
                ListNode tempNode = head;
                head = tempNode.next;
                return head;
            }



            curr = head;
            counter = 0;
            while(counter<index){ // 0 < 1
                curr = curr.next;
                counter++;
            }
            // 這樣curr會在1
            curr.next = curr.next.next;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}










