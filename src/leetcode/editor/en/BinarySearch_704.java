package leetcode.editor.en;

public class BinarySearch_704 {
    public static void main(String[] args) {
        Solution solution = new BinarySearch_704().new Solution();
        int[] nums = {-1,0,3,5,9,12,200, 201, 288, 301, 654}; // 不重複，最多10000，最少1個數字，數字範圍-9999 - 9999
        int target = 3;
        int result = solution.search(nums,target);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int start = 0;
            int end = nums.length-1; // 5
            int mid = 0;

            while(start<=end){ // 注意這邊，交疊的也要執行才行

                if(nums[start] == target)
                    return start;
                else if (nums[end] == target)
                    return end;

                mid = (start+end) / 2; // 2

                if(target>nums[mid]){ // 3>0
                    start = mid+1; // 3
                } else if (target<nums[mid]){
                    end = mid-1;
                } else {
                    return mid;
                }

            }


            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
