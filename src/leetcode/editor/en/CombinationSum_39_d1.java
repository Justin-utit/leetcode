package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39_d1 {

    public static void main(String[] args) {
        Solution solution = new CombinationSum_39_d1().new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        solution.combinationSum(candidates,target);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            Input: candidates = [2,3,6,7], target = 7
            Output: [[2,2,3],[7]]

            My understanding is time complexity is O(N^(T/M)) and
            space complexity is O(T/M). -> 7/2
            T is the target value, M is the minimum value of the candidates.
            As T/M will the maximum depth that the recursive call can reach. Not sure if it's right though.

            採用:
            TC:
             min is the minimal value of among the numbers. The search tree level is target/min.
             At each level, the number of fan out is n. Then the upper bound is  O(n^(target/min)).
            SC:
                dfs callstack
                空间复杂度取决于递归的栈深度，在最差情况下需要递归 O( n*(target/min) ) 层。

         */
        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.nums = candidates;

            dfs(new LinkedList<>(), target, 0);

            return res;
        }

        private void dfs(List<Integer> currentList, int target, int index) {

            if(target==0){
                res.add(new LinkedList<>(currentList));
            } else {
                for(int i = index; i<nums.length; i++){
                    if(nums[i]>target)
                        break;
                    currentList.add(nums[i]);
                    dfs(currentList,target-nums[i],i);
                    currentList.remove(currentList.size()-1);
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}















