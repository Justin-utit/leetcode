package leetcode.editor.en;

public class BestTimetoBuyandSellStock_121 {

    public static void main(String[] args) {
        Solution solution = new BestTimetoBuyandSellStock_121().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int min = Integer.MAX_VALUE;
            int max_profit = 0;
            for(int i=0; i<prices.length; i++){
                if(prices[i]<min){
                    min = prices[i];
                } else if(prices[i]-min > max_profit){
                    max_profit = prices[i]-min;
                }
            }

            return max_profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
