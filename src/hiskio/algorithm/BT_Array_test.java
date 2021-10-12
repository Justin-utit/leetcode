package hiskio.algorithm;

public class BT_Array_test {

    public static void main(String[] args) {
        Integer[] nums = {
                5,
                2,6,
                1,4,null,7,
                null,null,3,null,null,null,null,null};

        BT_Array bt = new BT_Array(nums);
        System.out.println();

        System.out.print("pre: ");
        bt.traverse_preorder();
        System.out.print("\nin: ");
        bt.traverse_inorder();
        System.out.print("\npost: ");
        bt.traverse_postorder();

        System.out.print("\n\npre: ");
        bt.traverse_preorder_dfsright();
        System.out.print("\nin: ");
        bt.traverse_inorder_dfsright();
        System.out.print("\npost: ");
        bt.traverse_postorder_dfsright();
    }

}
