package regex;

/**
 * @author: Lim
 * @date: 2019/8/16
 */
public class Main {
    public static void main(String[] args) {

        String idcard1 = "421126199502041718";
        String idcard2 = "421126199501010101";

        System.out.println(RegexUtil.matches(RegexUtil.ID_NUMBER, idcard1));
        System.out.println(RegexUtil.matches(RegexUtil.ID_NUMBER, idcard2));

//        contains();

    }

    private static void contains() {
        String s = "all,abc";
        String s2 = "abc,report";
        String s3 = "all,abc,report";
        String s4 = "abc";

        System.out.println(s.matches("all|report"));
        System.out.println(s2.matches("all|report"));
        System.out.println(s3.matches("all|report"));
        System.out.println(s4.matches("all|report"));

    }

}
