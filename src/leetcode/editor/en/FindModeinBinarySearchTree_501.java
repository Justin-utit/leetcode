package leetcode.editor.en;

import java.util.*;

public class FindModeinBinarySearchTree_501 {
    public static void main(String[] args) {
        Solution solution = new FindModeinBinarySearchTree_501().new Solution();


    }
//leetcode submit region begin(Prohibit modification and deletion)
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
}
    class Solution {
        public int[] findMode(TreeNode root) {

            if(root==null)
                return null;

            Map<Integer,Integer> map = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                int size = q.size();
                for(int i = 0 ; i<size; i++){
                    TreeNode treeNode = q.poll();
                    if(treeNode!=null){
//                        System.out.println(treeNode.val);
                        int key = treeNode.val;
                        if(map.get(key)==null){
                            map.put(key,1);
                        }else {
                            int curNum = map.get(key);
                            map.put(key,curNum+1);
                        }

                        if(treeNode.left!=null)
                            q.add(treeNode.left);
                        if(treeNode.right!=null)
                            q.add(treeNode.right);
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            for (var entry : map.entrySet()) {
//                System.out.println(entry.getKey() + "/" + entry.getValue());
                int currTimes = entry.getValue();
                if(currTimes>max)
                    max = currTimes;
            }
            List<Integer> list = new ArrayList<>();
            for (var entry : map.entrySet()) {
                int currTimes = entry.getValue();
                if(currTimes==max)
                    list.add(entry.getKey());
            }

            int[] intArr = new int[list.size()];
            for(int i = 0; i<list.size(); i++){
                Integer num = list.get(i);
                intArr[i] = num;
            }

            return intArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

















