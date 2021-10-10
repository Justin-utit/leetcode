package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        Solution solution = new ThreeSum_15().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0, 0, 0};
        List<List<Integer>> list = solution.threeSum(nums);
        System.out.println(list);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();

            Arrays.sort(nums); // 小到大
            for(int i = 0; i<nums.length-2; i++){
                if(i==0 || (i>0 && nums[i]!=nums[i-1])){

                    int start = i+1; // 1
                    int end = nums.length-1; // 2

                    // {-1,0,1,2,-1,-4};
                    // {-4,-1,-1,0,1,2};
                    while(start<end){
                        int a = nums[i];
                        int b = nums[start];
                        int c = nums[end];

                        int sum = a+b+c;
                        if(sum==0){
                            list.add(Arrays.asList(a,b,c));

                            // 這個只能放這邊
                            while(start<end && nums[start]==nums[start+1])
                                start++;
                            while(start<end && nums[end]==nums[end-1])
                                end--;

                            start++;
                            end--;
                        } else if(sum>0){ // end 左移一格
                            end--;
                        } else { // 小於0: start 右移一格
                            start++;
                        }

                    }

                }

            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}













