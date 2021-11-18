package leetcode.editor.en;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations_1005 {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations_1005().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i : nums)
                queue.add(i);

            while(k-- > 0){
                queue.offer(-queue.poll());
            }

            int sum = 0;
            while(!queue.isEmpty()){
                sum+= queue.poll();
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
