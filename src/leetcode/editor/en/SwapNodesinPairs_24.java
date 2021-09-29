package leetcode.editor.en;

public class SwapNodesinPairs_24 {
    public static void main(String[] args) {
        Solution solution = new SwapNodesinPairs_24().new Solution();
        ListNode head = new ListNode(0); // 視作n0
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;

        ListNode listNode = solution.swapPairs(head);
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
        public ListNode swapPairs(ListNode head) {
            // 0 1 2 3
            // 1 0 3 2

            // 沒東西
            if(head==null)
                return null;

            // 1個東西
            if(head.next==null)
                return head;

            ListNode currNode = head;
            int counter = 0;
            while (currNode!=null&&currNode.next!=null) {
                currNode = currNode.next;
                counter++;
            }
            // currNode 在尾了
            // counter應為3，所以size為counter+1=4
            int size = counter+1; // 4
            int[] intArr = new int[size];

            currNode = head;
            counter = 0;
            while (counter<size) { // 0 1 2 3
                intArr[counter] = currNode.val;
                currNode = currNode.next;
                counter++;
            }
//            System.out.println(intArr); // 0 1 2 3

            for(int i = 0; i<intArr.length-1; i+=2){ // i max => 2
                int j = i+1; // 1
                int temp = intArr[j];
                intArr[j] = intArr[i];
                intArr[i] = temp;
            }
//            System.out.println(intArr); // 0 1 2 3

            currNode = head;
            for(int i =0; i<intArr.length; i++){ // 0 1 2 3
                int num = intArr[i];
                currNode.val = num;
                currNode = currNode.next;
            }
//            System.out.println(head);

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}




















