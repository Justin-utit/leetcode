package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern_459 {

    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern_459().new Solution();
        String str = "abcabcabcabc"; // 12
        str = "aabaaba";
        boolean res = solution.repeatedSubstringPattern(str);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {

            for(int j = 1; j<=s.length()/2; j++){
//                System.out.println(j);
                boolean res = extracted(s, j);
                if(res==true)
                    return true;

            }



            return false;
        }

        private boolean extracted(String s, int len) {

            if(s.length() % len == 0){
                List<Boolean> list = new ArrayList<>();

                String firstStr = "";
                for(int i = 0; i< s.length(); i+=len){
//                System.out.println(i);

                    if(i+len <= s.length()){
                        String tempStr = s.substring(i,i+len);
                        if(i==0)
                            firstStr = tempStr;
                        else
                            list.add(tempStr.equals(firstStr)); // 每個跟第一個比對的結果，同則true
                    }
                }

                // 看是否為allTrue
                boolean first = list.get(0);


                boolean allEqual = true;
                for (int i = 1; i<list.size(); i++) {
                    if(first != list.get(i))
                        allEqual = false;
                }

                return first==true && allEqual==true;
            } else
                return false;


        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}
