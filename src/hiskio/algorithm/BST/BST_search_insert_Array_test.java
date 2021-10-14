package hiskio.algorithm.BST;

public class BST_search_insert_Array_test {

    public static void main(String[] args) {
                /*
            build tree (add)
         */
        Integer[] nums = {5,2,6,1,4,7,3};
        BST_search_insert_Array bst = new BST_search_insert_Array(nums);
        bst.buildtree();
        System.out.println();
    }

}
