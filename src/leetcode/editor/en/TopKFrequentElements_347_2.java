package leetcode.editor.en;

import java.util.*;

public class TopKFrequentElements_347_2 {

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements_347_2().new Solution();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
//        int[] nums = {1};
//        int k = 1;
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
//                if(map.get(i)==null){
//                    map.put(i,1);
//                } else {
//                    int n = map.get(i);
//                    map.put(i,n+1);
//                }
                map.put(i,map.getOrDefault(i,0)+1);
            }

            System.out.println(map);

            /*
            1: 3
            2: 2
            3: 1
             */


            PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
            int[] res = new int[k];
            int pos = 0;

            List<Integer> list = new ArrayList<>();

            // 只要放map.Entry進去，就會自動大的在前面了
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                Integer key = entry.getKey();
//                Integer value = entry.getValue();
                pq.add(entry);
            }

            // i = 2
            // >0
            for(int i = list.size()-1; i> list.size()-1-k; i--){
                res[pos] = pq.poll().getKey();
                pos++;
            }


            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}











