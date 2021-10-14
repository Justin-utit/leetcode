package leetcode.editor.en;

public class BT_List_102_test {
    public static void main(String[] args) {
        Integer[] nums =
                {5,
                2,6,
                1,4,null,7,
                null,null,3,null,null,null,null,null};
        BT_List_102 bt_list_102 = new BT_List_102(nums);
        bt_list_102.buildtree();
        System.out.println();

        bt_list_102.traverse_levelorder_bfs();


    }
}
