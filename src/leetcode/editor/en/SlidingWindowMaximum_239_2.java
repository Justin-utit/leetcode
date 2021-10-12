package leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
    真的蠻難, 一個早上一題寫不出來，不過現階段難的不會就算了，先把中等、簡單完成，未來再回頭看難度的題目。
    反正，以後看到難的，就先跳過吧。先把中等跟簡單的完成，有餘力再說。
 */

public class SlidingWindowMaximum_239_2 {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum_239_2().new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

//        int[] nums = {8,7,6,9};
//        int k = 2;

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
            int[] output = new int[nums.length-len];
            int index = 0;

            // addLast 添加元素到队尾
            // removeFirst 取队首元素并删除
            // getLast() 取队尾元素但不删除
            Deque<Integer> dq = new ArrayDeque<>(); // 這個是用來存index的，才能判斷過窗，才能刪除
            if(dq.isEmpty())
                dq.addFirst(0);

            // 1 3 -1 -3 5 3 6 7      k=3
            for(int i = 0; i<nums.length-len; i++){

                int j = i+k;


                for(int a = i; a<j; a++){ // 1 3 -1
//                    System.out.printf(" %s ",nums[a]);
                    int leftIndex = dq.getFirst();
                    if(leftIndex<i) // 出隊就移除
                        dq.removeFirst();

                    int last = nums[dq.getLast()];
                    int curr = nums[a];
                    if(curr>=last){
                        dq.removeLast();
                        dq.addLast(a);
                    }else {
                        dq.addLast(a);
                    }

                }

                output[index] = nums[dq.removeFirst()];
                index++;


            }

            return output;
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







