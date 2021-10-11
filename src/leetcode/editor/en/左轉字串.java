package leetcode.editor.en;

public class 左轉字串 {

    public static void main(String[] args) {
        /*
            输入: s = "lrloseumgh", k = 6
            输出: "umghlrlose"
         */

        String res = reverseLeftWords("lrloseumgh", 6);
        System.out.println(res);

    }

    public static String reverseLeftWords(String s, int n) {
        String left = s.substring(0,n);
        String right = s.substring(n);
        return right+left;
    }


}
