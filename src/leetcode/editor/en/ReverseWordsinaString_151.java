package leetcode.editor.en;

public class ReverseWordsinaString_151 {
    /*
    					测试用例:"a good   example"
						测试结果:"example   good a"
						期望结果:"example good a"
     */
    public static void main(String[] args) {
        Solution solution = new ReverseWordsinaString_151().new Solution();
        String str = "a good   example";
        String res = solution.reverseWords(str);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {

            s = s.trim();
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = strings.length-1; i>=0; i--){

                if(strings[i].length()>0){
                    sb.append(strings[i]);
                    sb.append(" ");
                }



            }
            String res = sb.toString().trim();


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
