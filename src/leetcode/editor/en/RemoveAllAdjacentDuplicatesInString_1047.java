package leetcode.editor.en;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString_1047().new Solution();
        String str = "abbaca";
        String res = solution.removeDuplicates(str);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {

            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i<chars.length; i++){

                if(stack.isEmpty()){
                    stack.push(chars[i]);
                } else if(i>0){

                    if(stack.peek()==chars[i])
                        stack.pop();
                    else
                        stack.push(chars[i]);

                }

            }

            String res = "";
            for(Character c : stack){
                res+=c;
            }




            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
