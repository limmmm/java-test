package str;

/**
 * @author Lim
 * @date 2020/2/5
 */
public class Main {

    public static void main(String[] args) {
        String s1 = "广州市荔湾区疾病预防控制中心";
        String s2 = "广东省/广州市/荔湾区/广州市荔湾区疾病预防控制中心";

        if(s2.contains("/")) {
            System.out.println(s2.lastIndexOf(s1));
        }
    }
}
