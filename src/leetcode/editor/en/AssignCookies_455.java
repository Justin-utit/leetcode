package leetcode.editor.en;

import java.util.Arrays;

public class AssignCookies_455 {

    public static void main(String[] args) {
        Solution solution = new AssignCookies_455().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {

            Arrays.sort(g);
            Arrays.sort(s);

            int a_pointer = 0;
            int b_pointer = 0;

            while (a_pointer<g.length&&b_pointer<s.length){
                if(s[b_pointer] >= g[a_pointer]){
                    a_pointer++;
                    b_pointer++;
                } else {
                    b_pointer++;
                }
            }

            return a_pointer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
