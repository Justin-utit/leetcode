package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringII_541 {
    public static void main(String[] args) {
        Solution solution = new ReverseStringII_541().new Solution();

//        String s = "abcdefg";
//        String s = "abcd";
        String s = "12341234123";
        int k = 4;

        solution.reverseStr(s,k);


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            // abcdefg
            // bacdfeg

            // 1234 1234 123
            // 4321 1234 321

            List<String> list = new ArrayList<>();
            for(int i = 0; i<s.length(); i+=k){

                if(i+k<s.length()){
                    String block = s.substring(i,i+k);
                    System.out.println(block);
                    list.add(block);
                } else {
                    String block = s.substring(i);
                    System.out.println(block);
                    list.add(block);
                }

            }

            // ab cd ef g
            // 0  1  2  3
            for(int i = 0; i<list.size(); i+=2){
                char[] chars = list.get(i).toCharArray();
                int start = 0;
                int end = chars.length-1;
                while(start<=end){
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }
                String str = String.valueOf(chars);
                list.set(i,str);
            }
            System.out.println(list);
            String result = "";
            for(String str : list){
                result+=str;
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
