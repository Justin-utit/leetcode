package leetcode.editor.en;

public class ImplementstrStr_28 {
    public static void main(String[] args) {
        Solution solution = new ImplementstrStr_28().new Solution();
        String haystack = "hello";
        String needle = "ll";
        haystack = "";
        needle = "";
        int res = solution.strStr(haystack,needle);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {

            int index = haystack.indexOf(needle);


            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
