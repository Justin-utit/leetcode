package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IntersectionofTwoArrays_349 {
    public static void main(String[] args) {
        Solution solution = new IntersectionofTwoArrays_349().new Solution();

//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = solution.intersection(nums1,nums2);
        System.out.println(result);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {


            HashSet<Integer> hashSet = new HashSet<>();
            for (int i1 : nums1){

                for(int i2 : nums2){
                    if(i1==i2){
                        hashSet.add(i1);
                    }

                }

            }

            List<Integer> list = new ArrayList<>();


            Iterator<Integer> iterator = hashSet.iterator();
            while (iterator.hasNext()){
//                intArr[pos] = iterator.next();
//                pos++;
                list.add(iterator.next());
            }

            int[] intArr = new int[list.size()];
            int pos = 0;

            for(Integer i : list){
                intArr[pos++] = i;
            }



            return intArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
