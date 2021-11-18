package leetcode.editor.en;

public class BestTimetoBuyandSellStockII_122 {
    public static void main(String[] args) {
        Solution solution = new BestTimetoBuyandSellStockII_122().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int total = 0;
            int min = prices[0];
            for(int i = 1; i<prices.length; i++){
                int profit = prices[i]-min;
                if(profit>0){
                    total+= profit;
                    min = prices[i];
                }
                min = Math.min(min, prices[i]);
            }

            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
