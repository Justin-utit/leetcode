package leetcode.editor.en;

public class RemoveElement_27 {
    public static void main(String[] args) {
        Solution solution = new RemoveElement_27().new Solution();
        int[] nums = {0,1,2,2, 3,0,4,2};
        int target = 2;
        int result = solution.removeElement(nums,target);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
    /*
        0 1 2 2 3 0 4 2

        0 1 - - 3 0 4 -

        0 1 - 4 3 0 - -

        0 1 0 4 3 - - -
     */
            int length = nums.length; // 8

            // 標記-1
            int counter = 0;
            for(int i = 0; i<length; i++){ // i = 0 - 7
                if(nums[i] == val) {
                    nums[i] = -1;
                    counter++;
                }
            }

            // 從後面看起，找到不是-1的，就把該不是-1的數，往前塞到前面-1的位置
            for(int i =length-1; i>=0; i--){ // 7
                if(nums[i]==-1)
                    continue;

                if(nums[i]!=-1){
                    for(int j = i-1; j>=0; j--){ // 往前找
                        if(nums[j]==-1){         // 找到-1
                            nums[j] = nums[i];   // 往前塞
                            break;
                        }
                    }
                }
            }


            return length-counter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
