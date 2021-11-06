package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning_131 {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning_131().new Solution();
        String s = "abc";
        solution.partition(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();

        public List<List<String>> partition(String s) {
            if(s==null || s.length()==0)
                return res;

            dfs(new LinkedList<>(), s, 0);

            return res;
        }

        private void dfs(List<String> currentList, String s, int index) {
            if(index==s.length())
                res.add(new LinkedList<>(currentList));
            else {
                for(int i = index; i<s.length(); i++){

//                    if(isPal(s,index,i)){
                        String str = s.substring(index,i+1);
                        System.out.println(str);

                        currentList.add(str);
                        dfs(currentList,s,i+1);
                        currentList.remove(currentList.size()-1);
//                    }

                }
            }

        }

        private boolean isPal(String s, int index, int i) {

            while(index<=i){
                if(s.charAt(index) != s.charAt(i))
                    return false;
                index++;
                i--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}














