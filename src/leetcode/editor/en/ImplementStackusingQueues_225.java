package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackusingQueues_225 {

    public static void main(String[] args) {
        MyStack solution = new ImplementStackusingQueues_225().new MyStack();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        public MyStack() {

        }

        public void push(int x) {
            if(q1.isEmpty()){
                q1.add(x);
            } else {
                while(!q1.isEmpty()){
                    int temp = q1.poll();
                    q2.add(temp);
                }
                q1.add(x);
                while (!q2.isEmpty()){
                    int temp = q2.poll();
                    q1.add(temp);
                }
            }
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty()&&q2.isEmpty();
        }

    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
