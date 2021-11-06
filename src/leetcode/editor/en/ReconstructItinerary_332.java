package leetcode.editor.en;

import java.util.*;

public class ReconstructItinerary_332 {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary_332().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
//        List<String> res = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for(int i = 0; i<tickets.size(); i++){
                List<String> ticket = tickets.get(i); // "JFK","SFO"
                String key = ticket.get(0);
                if(map.get(key)==null)
                    map.put(key, new PriorityQueue<>());

                map.get(key).add(ticket.get(1));
            }

            dfs("JFK");

            return res;
        }

        private void dfs(String destination) {
            PriorityQueue<String> queue = map.get(destination);
            while(queue!=null&&queue.size()!=0){
                dfs(queue.poll());
            }
            res.addFirst(destination);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
