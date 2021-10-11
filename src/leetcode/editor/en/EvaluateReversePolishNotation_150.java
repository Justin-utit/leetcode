package leetcode.editor.en;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation_150().new Solution();

        String[] tokens = {"2","1","+","3","*"};
        int res = solution.evalRPN(tokens);
        System.out.println(res); // 9


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i<tokens.length; i++){

                if(isNumeric(tokens[i]))
                    stack.push(Integer.parseInt(tokens[i]));
                else {

                    String operator = tokens[i];
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (operator){
                        case "+":
                            stack.push(a+b);
                            break;
                        case "-":
                            stack.push(a-b);
                            break;
                        case "*":
                            stack.push(a*b);
                            break;
                        case "/":
                            stack.push(a/b);
                            break;
                    }

                }

            }




            return stack.peek();
        }

        public boolean isNumeric(String string) {
            try {
                Integer.parseInt(string);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


















