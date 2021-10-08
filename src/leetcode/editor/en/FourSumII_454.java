package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {
    public static void main(String[] args) {
        Solution solution = new FourSumII_454().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // A + B + C + D = 0
            // find the match: (A+B) = -(C+D)
            Map<Integer, Integer> sumFrequency = new HashMap<>();
            // 記錄各種sum出現的次數
            for(int a : nums1){
                for(int b : nums2){
                    int sum = a+b;
                    if(sumFrequency.get(sum)==null){
                        sumFrequency.put(sum,1);
                    }else {
                        int n = sumFrequency.get(sum);
                        sumFrequency.put(sum,n+1);
                    }
                }
            }

            // find the match
            int counter = 0;
            for(int c : nums3){
                for(int d : nums4){
                    int sumCD = c+d;
                    if(sumFrequency.containsKey(-sumCD)){
                        int frequency = sumFrequency.get(-sumCD);
                        counter+=frequency;
                    }
                }
            }



            return counter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}










