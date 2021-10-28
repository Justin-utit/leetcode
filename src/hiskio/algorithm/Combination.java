package hiskio.algorithm;

import leetcode.editor.en.CombinationSumII_40;

import java.util.LinkedList;
import java.util.List;

public class Combination {


    public static void main(String[] args) {
        Combination.Solution solution = new Combination().new Solution();
        int[] nums = {1,2,3};
        int n = 3;
        solution.combination(nums,n);

    }

    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int n = 0;
        int[] nums = null;
        public List<List<Integer>> combination(int[] nums, int n) {

            if(nums==null || nums.length==0)
                return res;

            // 共用的常數放外面
            this.n = n;
            this.nums = nums;

            dfs(new LinkedList<>(), 0);

            return res;
        }

        private void dfs(List<Integer> currentList, int index) {
            if(currentList.size()==n){
                res.add(new LinkedList<>(currentList));
            } else {
                for(int i = index; i<nums.length; i++){
                    currentList.add(nums[i]);
                    dfs(currentList,i+1);
                    currentList.remove(currentList.size()-1);
                }
            }

        }
    }


}







