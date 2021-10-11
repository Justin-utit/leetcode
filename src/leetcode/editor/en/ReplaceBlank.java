package leetcode.editor.en;

public class ReplaceBlank {

    public static void main(String[] args) {
            String str = "We are happy.";
            String res = replaceBlank(str);
            System.out.println(res);

    }

    public static String replaceBlank(String s){
        s = s.replace(" ","%20");
        return s;
    }

}
