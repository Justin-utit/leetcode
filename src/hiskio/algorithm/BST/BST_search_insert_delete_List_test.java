package hiskio.algorithm.BST;

public class BST_search_insert_delete_List_test {

    public static void main(String[] args) {

        /*
            build tree (add)
         */
        int[] nums = {5,2,6,1,4,7,3};
        BST_search_insert_delete_List bst = new BST_search_insert_delete_List(nums);
        bst.buildtree();
        System.out.println();
    }
}
