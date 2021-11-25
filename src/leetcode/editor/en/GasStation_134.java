package leetcode.editor.en;

public class GasStation_134 {

    public static void main(String[] args) {
        Solution solution = new GasStation_134().new Solution();
        // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2,};
        int res = solution.canCompleteCircuit(gas,cost);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://www.youtube.com/watch?v=9jroutywago
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curr = 0;
            int tempSum = 0;
            int total = 0;
            for(int i = 0; i<gas.length; i++){
                tempSum += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if(tempSum<0){
                    curr = i+1;
                    tempSum = 0;
                }
            }

            return total>=0? curr : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
