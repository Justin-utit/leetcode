package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {

    public static void main(String[] args) {
        Solution solution = new RansomNote_383().new Solution();
        String ransomNote = "a";
        String magazine = "b";
        boolean result = solution.canConstruct(ransomNote,magazine);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            Map<String,Integer> map = new HashMap<>(); // 記錄每個字元出現的頻率
            char[] chars = ransomNote.toCharArray();
            for(char c : chars){
                String key = String.valueOf(c);
                if(map.containsKey(key)){
                    int currentNum = map.get(key);
                    map.put(key,currentNum+1);
                } else {
                    map.put(key,1);
                }
            }

            Map<String,Integer> map2 = new HashMap<>(); // 記錄每個字元出現的頻率
            char[] chars2 = magazine.toCharArray();
            for(char c : chars2){
                String key = String.valueOf(c);
                if(map2.containsKey(key)){
                    int currentNum = map2.get(key);
                    map2.put(key,currentNum+1);
                } else {
                    map2.put(key,1);
                }
            }

            boolean magazineCanCover = true;
            // return true if ransomNote can be constructed from magazine
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                if(map2.get(key)!=null && map2.get(key) >=value){ // magazine有且量夠
                    // good
                } else {
                    // no good
                    magazineCanCover = false;
                }


            }

            return magazineCanCover;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
