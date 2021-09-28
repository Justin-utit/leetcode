package leetcode.editor.en;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList_206().new Solution();

        ListNode head = new ListNode(0); // 視作n0
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = solution.reverseList(head);
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
        public ListNode reverseList(ListNode head) {

            if(head==null)
                return null;

            // 0 1 2 3 4
            ListNode currentNode = head;
            int counter = 0;
            while(currentNode!=null&&currentNode.next!=null){
                currentNode = currentNode.next;
                counter++;
            }
            int size = counter+1;
            int[] intArr = new int[size];

            currentNode = head;
            counter = 0;
            while(counter<size){
                intArr[counter] = currentNode.val;

                currentNode = currentNode.next;

                counter++;
            }

//            System.out.println(intArr);

            ListNode currNode = head;
            for(int i = intArr.length-1; i>=0; i--){ // 4 3 2 1 0
                // System.out.println(intArr[i]);
                currNode.val = intArr[i];
                currNode = currNode.next;
            }


//            System.out.println(currentNode); // 4
//            System.out.println(counter); // 4


            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
