package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses_93 {
    public static void main(String[] args) {
        Solution solution = new RestoreIPAddresses_93().new Solution();
        String s = "25525511135";
        solution.restoreIpAddresses(s);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new LinkedList<>();
        public List<String> restoreIpAddresses(String s) {
            if(s==null|| s.length()<4 ||s.length()>12)
                return res;
            dfs(s, new StringBuilder(), 0, 0);
            return res;
        }

        private void dfs(String s, StringBuilder sb, int part, int index) {


            if(part==4 && index==s.length()){
                res.add(sb.toString());
            } else {
                for(int i =1; i<=3; i++){ // 1 2 3

                    if(index+i > s.length())
                        break;

                    String val = s.substring(index, index+i); // 右切1 切2 切3
                    if(Integer.valueOf(val)>255 || (val.length()>1&&val.startsWith("0")))
                        break;

                    int len = sb.length();
                    if(index==0)
                        sb.append(val);
                    else {
                        sb.append(".");
                        sb.append(val);
                    }

                    System.out.println(index+i);
                    dfs(s,sb,part+1, index+i);
                    sb.delete(len,len+i+1);

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}












