package leetcode.editor.en;

public class DesignLinkedList_707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new DesignLinkedList_707().new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.addAtTail(6);
        linkedList.addAtHead(0);
        linkedList.addAtTail(7);

        linkedList.addAtIndex(8, 99);   //链表变为1-> 2-> 3

//        linkedList.get(9);            //返回2

        // 0 1 2 3 4 5 6 7 99
        linkedList.deleteAtIndex(8);  //现在链表是1-> 3

        System.out.println(linkedList);
//        linkedList.get(1);            //返回3


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        public class Node { // this is a node
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head;
        int size; // number of nodes

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new Node(-1);
            size = 0;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            //       v
            // 0 1 2 3 4 5 6 7 99  (size = 9;

            if (index < 0 || index >= size || size == 0) {
                return;
            }

            if (index == 0) {
                Node tempNode = head;
                head = tempNode.next;
                size--;
                return;
            }

            Node currentNode = head;
            int counter = 0;

            while (counter < index - 1) { // 0 1
                currentNode = currentNode.next;
                counter++;
            }
            currentNode.next = currentNode.next.next;

            size--;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            // v
            // 0 1 2 3 4 5 6 7 99 -> size 9 index若為9

            if (index < 0 || index >= size) {
                return -1;
            }

            if (index == 0) {
                return head.val;
            }

            Node currNode = head;
            int counter = 0;
            while (counter < index) { // 0 1 2 3 4 5 6 7
                currNode = currNode.next;
                counter++;
            }


            return currNode.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {

            // 0 1 2 -> size 3 (index 可以是 0 1 2 3) 4超過邊界了
            if (index < 0 || index > size) {
                return;
            }

            // head(-1) size 0
            // index 0 val 1
            if (size == 0) { // 若現在是空的，不管什麼進來，就是放第一個，size++ 收工
                head = new Node(val);
                size++;
                return;
            }

            if (index == 0) { // 確定放第一個位置，也好處理
                Node tempNode = head;
                Node nodeToAdd = new Node(val);
                head = nodeToAdd;
                head.next = tempNode;
                size++;
                return;
            }

            // 0 1 2 3 4
            Node currNode = head;
            int counter = 0;
            while (counter < index - 1) { // 0<2 1<2 -> 向前移兩格，currNode會在2
                currNode = currNode.next;
                counter++;
            }

            Node nodeToAdd = new Node(val);
            nodeToAdd.next = currNode.next;
            currNode.next = nodeToAdd;


            size++;
        }

    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
