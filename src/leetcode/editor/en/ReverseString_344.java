package leetcode.editor.en;

public class ReverseString_344 {

    public static void main(String[] args) {
        Solution solution = new ReverseString_344().new Solution();
        char[] chars = {'h','e','l','l','o'};
        solution.reverseString(chars);


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {

            int a = 0;
            int b = s.length-1;

            while(a<=b){

                char temp = s[a];
                s[a] = s[b];
                s[b] = temp;

                a++;
                b--;
            }

            System.out.println(s);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
