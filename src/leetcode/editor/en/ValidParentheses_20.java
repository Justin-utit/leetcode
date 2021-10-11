package leetcode.editor.en;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses_20().new Solution();

        /*
        		测试用例:"){"
         */

        String s = "{[()]}";
        s = "){";
        boolean res = solution.isValid(s);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            if(chars.length % 2 != 0)
                return false;

            for(char c : chars){
                switch (c) {
                    case '(':
                        stack.push(')');
                        break;
                    case '{':
                        stack.push('}');
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case ')':
                        char res1 = 0;
                        if(!stack.isEmpty())
                            res1 = stack.pop();
                        if(res1!=')')
                            return false;
                        break;
                    case '}':
                        char res2 = 0;
                        if(!stack.isEmpty())
                            res2 = stack.pop();
                        if(res2!='}')
                            return false;
                        break;
                    case ']':
                        char res3 = 0;
                        if(!stack.isEmpty())
                            res3 = stack.pop();
                        if(res3!=']')
                            return false;
                        break;
                }

            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}















