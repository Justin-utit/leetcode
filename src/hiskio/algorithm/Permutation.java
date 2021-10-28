package hiskio.algorithm;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation.Solution solution = new Permutation().new Solution();
        int[] nums = {1,2,3};
        int n = 2;
        solution.permutation(nums,n);

    }

    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int n = 0;
        int[] nums = null;

        public List<List<Integer>> permutation(int[] nums, int n) {

            if(nums==null || nums.length==0)
                return res;

            // 共用的常數放外面
            this.n = n;
            this.nums = nums;

            dfs(new LinkedList<>(), new boolean[nums.length]);

            return res;
        }

        private void dfs(List<Integer> currentList, boolean[] used) {
            if(currentList.size()==n){
                res.add(new LinkedList<>(currentList));
            } else {
                for(int i = 0; i<nums.length; i++){

                    if(used[i]==true)
                        continue;

                    currentList.add(nums[i]);
                    used[i] = true;
                    dfs(currentList,used);
                    currentList.remove(currentList.size()-1);
                    used[i] = false;
                }
            }

        }
    }


}
