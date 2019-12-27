package encode;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Lim
 * @date 2019/12/23
 */
public class HtmlEncode {
    public static void main(String[] args) {
        String s = "xXx";
        System.out.println(URLEncoder.encode(s));

        String a = "&times; ";
        System.out.println(URLDecoder.decode(a));
    }
}
