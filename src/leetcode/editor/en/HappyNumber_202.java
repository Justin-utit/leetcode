package leetcode.editor.en;

public class HappyNumber_202 {

    public static void main(String[] args) {
        Solution solution = new HappyNumber_202().new Solution();

        int num = 19;
        boolean result = solution.isHappy(num);
        System.out.println(result);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {

            int result = n;


            int counter = 0;
            while (result!=1){
                result = dividePowSum(result);
                // System.out.println(result);
                counter++;
                if(counter==50000)
                    return false;
            }



            return true;
        }

        public int dividePowSum(int n){
            char[] chars = String.valueOf(n).toCharArray();
            int sum = 0;
            for(char c : chars){
                int num = Integer.valueOf(c+"");
                double numPow2 = Math.pow(num,2);
                sum += numPow2;
            }
//            System.out.println(sum);
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
