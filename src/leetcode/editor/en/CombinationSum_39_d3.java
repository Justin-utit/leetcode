package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39_d3 {

    public static void main(String[] args) {
        Solution solution = new CombinationSum_39_d3().new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        solution.combinationSum(candidates,target);
    }
    /*
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    條件:
        1 candidates -> unique (數組內的數字不重複) (最少1個數字，範圍1-200)
        2 The same number may be chosen from candidates an unlimited number of times.
        -> 但數組內的數字，可以被多次使用
        3 範圍: 1 <= target <= 500

        Constraints:
        1 <= candidates.length <= 30
        1 <= candidates[i] <= 200
        All elements of candidates are distinct.
        1 <= target <= 500


    解題:
        用 backtracking (dfs), 進行遍歷
        每遍歷一個數，target就減去該數，一直減到零為止，例如 2, 2, 3 (7-2=5, 5-2=3, 3-3=0)
        當target等於零時，就找到組合為7的數組(base case)

        時間:

        空間:


     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*
        int[] candidates = {2,3,6,7};
        int target = 7;
            條件:
        1 candidates -> unique (數組內的數字不重複) (最少1個數字，範圍1-200)
        2 The same number may be chosen from candidates an unlimited number of times.
        -> 但數組內的數字，可以被多次使用
        3 範圍: 1 <= target <= 500
 */
        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums = candidates;

            dfs(new LinkedList<>(), target, 0);

            return res;
        }

        private void dfs(List<Integer> currentList, int target, int index) {
            // base case
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















