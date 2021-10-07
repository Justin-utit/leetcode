package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    public static void main(String[] args) {
        Solution solution = new ValidAnagram_242().new Solution();
        String s = "anagram", t = "nagaram";
        boolean result = solution.isAnagram(s,t);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {

            Map<String,Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                String key = String.valueOf(c);
                Integer num = map.get(key);
                if(num==null)
                    map.put(key,1);
                else
                    map.put(key,++num);

            }

            Map<String,Integer> map2 = new HashMap<>();
            for(char c : t.toCharArray()){
                String key = String.valueOf(c);
                Integer num = map2.get(key);
                if(num==null)
                    map2.put(key,1);
                else
                    map2.put(key,++num);
            }

            System.out.println(map);
            System.out.println(map2);


            return map.equals(map2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
