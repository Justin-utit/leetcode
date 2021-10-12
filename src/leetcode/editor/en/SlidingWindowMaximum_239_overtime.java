package leetcode.editor.en;

import java.util.Arrays;

public class SlidingWindowMaximum_239_overtime {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum_239_overtime().new Solution();
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

        int[] nums = {7,2,4};
        int k = 2;

        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(res); // [7,4]


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            if(k==1)
                return nums;
            if(nums.length==2 && k==2){
                int[] temp = new int[1];
                if(nums[0]>nums[1])
                    temp[0] = nums[0];
                else
                    temp[0] = nums[1];

                return temp;
            }


            int len = k-1;

            int[] res = new int[nums.length-len];
            int index = 0;


            // 724
            for(int i = 0; i<nums.length-len; i++){

                int j = i+k;

                int[] intArr = new int[k];
                int pos = 0;
                for(int a = i; a<j; a++){
//                    System.out.printf(" %s ",nums[a]);
                    intArr[pos] = nums[a];
                    pos++;
                }

                Arrays.sort(intArr);
                int max = intArr[intArr.length-1];
//                System.out.println(max);
                res[index] = max;
                index++;

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

/*
 0  1  2
 1  2  3
 2  3  4
 3  4  5
 4  5  6
 5  6  7
 */







