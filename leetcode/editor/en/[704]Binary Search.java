//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 < nums[i], target < 104 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 
// 👍 2118 👎 75

package leetcode.editor.en;
public class Binary Search{
	public static void main(String[] args) {
		Solution solution = new Binary Search().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

		int start = 0;
		int end = nums.length-1; // 5
		int mid = 0;

		while(start<=end){

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