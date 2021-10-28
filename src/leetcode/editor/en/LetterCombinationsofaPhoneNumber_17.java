package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsofaPhoneNumber_17().new Solution();
        String digits = "23";
        solution.letterCombinations(digits);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new LinkedList<>();
                                // 2     3      4      5     6       7       8      9
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        public List<String> letterCombinations(String digits) {

            if(digits.length()==0)
                return res;

            dfs(digits, "", 0);

            return res;
        }

        private void dfs(String digits, String currentStr, int currentIndex) { // "23", "", 0

            if(currentStr.length()==digits.length()){
                res.add(new String(currentStr));
            } else {

                int val = Character.getNumericValue(digits.charAt(currentIndex)); // 2, 3
                char[] chars = map[val].toCharArray(); // {a,b,c}, {d,e,f}
                for(int i =0; i<chars.length; i++){
                    currentStr+=chars[i];
                    currentIndex++;
                    dfs(digits, currentStr, currentIndex);
                    currentStr = currentStr.substring(0,currentStr.length()-1);
                    currentIndex--;
                }

            }

        }



    }
//leetcode submit region end(Prohibit modification and deletion)
}
