package leetcode.editor.en;

import java.util.Queue;
import java.util.Stack;

public class ImplementQueueusingStacks_232 {
    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueusingStacks_232().new MyQueue();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            if(outputStack.isEmpty()) // 注意只有在outputStack是空的情況下可以搬
                shiftContents();
            int res = outputStack.pop();
            return res;
        }

        public int peek() {
            if(outputStack.isEmpty()) // 注意只有在outputStack是空的情況下可以搬
                shiftContents();
            int res = outputStack.peek();
            return res;
        }

        public boolean empty() {
            return inputStack.isEmpty()&&outputStack.isEmpty();
        }

        public void shiftContents(){
            while(!inputStack.isEmpty()){
                int temp = inputStack.pop();
                outputStack.push(temp);
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
}
