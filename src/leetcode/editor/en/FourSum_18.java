package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

    public static void main(String[] args) {
        Solution solution = new FourSum_18().new Solution();

//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {0,0,0,0};
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums,target);
        System.out.println(result);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();

            Arrays.sort(nums);
            // {-2,-1,0,0,1,2}
            for(int i = 0; i<nums.length-3; i++){
                if(i>0 && nums[i]==nums[i-1]) continue;
                for(int j = i+1; j<nums.length-2; j++){
                    if(j>i+1 && nums[j]==nums[j-1]) continue;

                    int start = j+1;
                    int end = nums.length-1;
                    while (start<end) {
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[start];
                        int d = nums[end];
                        if(target == a+b+c+d){
                            list.add(Arrays.asList(a,b,c,d));
                            while(start<end&&nums[start]==nums[start+1])
                                start++;
                            while(start<end&&nums[end]==nums[end-1])
                                end--;
                            start++;
                            end--;
                        } else if(target < a+b+c+d){
                            end--;
                        } else {
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
