package leetcode.editor.en;

import java.util.*;

public class TopKFrequentElements_347_LibNotAllowed {

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements_347_LibNotAllowed().new Solution();
//        int[] nums = {1,1,1,2,2,3};
//        int k = 2;
        int[] nums = {1};
        int k = 1;
        int[] res = solution.topKFrequent(nums,k);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            if(nums.length==1&&k==1){
                return nums;
            }

            Map<Integer,Integer> map = new HashMap<>();

            for(int i : nums){
                if(map.get(i)==null){
                    map.put(i,1);
                } else {
                    int n = map.get(i);
                    map.put(i,n+1);
                }
            }

            System.out.println(map);


            /*
            1: 3
            2: 2
            3: 1
             */

            map = sortByValue(map);

            int[] res = new int[k];
            int pos = 0;

            List<Integer> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                list.add(key);
            }

            // i = 2
            // >0
            for(int i = list.size()-1; i> list.size()-1-k; i--){
                res[pos] = list.get(i);
                pos++;
            }


            return res;
        }
    }

    public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
//leetcode submit region end(Prohibit modification and deletion)
}











