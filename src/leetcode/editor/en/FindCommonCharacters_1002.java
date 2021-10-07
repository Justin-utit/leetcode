package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters_1002 {

    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters_1002().new Solution();
//        String[] strArr = {"bella","label","roller"};
//        String[] strArr = {"cool","lock","cook"};
        String [] strArr = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        List<String> list = solution.commonChars(strArr);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {



            List<Map<String,Integer>> list = new ArrayList<>();

            for(int i = 0; i<words.length; i++){

                char[] charArr = words[i].toCharArray();
                Map<String,Integer> map2 = new HashMap<>();
                for(char c : charArr){
                    String key = String.valueOf(c);
                    if(map2.get(key)==null){
                        map2.put(key,1);
                    }else{
                        Integer num = map2.get(key);
                        map2.put(key,++num);
                    }
                }

                list.add(map2);
            }

            System.out.println(list);

            // acabcddd
            // a b c d
            // 2 1 2 3
            Map<String,Integer> map = list.get(0);

            List<String> toRemove = new ArrayList<>();

            for(int i = 1; i<list.size(); i++){
                Map<String,Integer> map3 = list.get(i);

                for (Map.Entry<String, Integer> entry : map.entrySet()) { // a b e l
                    String key = entry.getKey(); // a
                    Integer value = entry.getValue(); // 1
                    if(map3.get(key)==null){
                        toRemove.add(key);
                    } else {
                        Integer num = map3.get(key);
                        if(num<value)
                            map.put(key,num);
                    }
                }
            }

            System.out.println(map);
            for(String key : toRemove){
                map.remove(key);
            }

            System.out.println(map);

            List<String> list2 = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                for(int i = 0; i<value; i++){
                    list2.add(key);
                }
            }

            return list2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}















