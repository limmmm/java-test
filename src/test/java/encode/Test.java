package encode;

import cn.hutool.core.text.UnicodeUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Base64;

/**
 * @author Lim
 * @date 2019/11/29
 */
public class Test {
    public static void main(String[] args) {
        /*String a = "1V4ZWxanFy6DnRuzPnSKpw==";
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            System.out.println(new String(decoder.decode(a), "GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String s1 = "<img src=#>%3cimg src=#%3e\\u003cimg src\\u003e\\x3cimg\\x3e1231112";
        String s2 = "<img src=#><img src=#>%3cimg%3e\\u003cimg src=#\\u003e\\x3cimg\\x3e11";
        String s3 = "<img src=#>%3cimg src=#%3e\u003cimg src\u003e\\x3cimg\\x3e1231112";
        String s4 = "<img src=#><img src=#>%3cimg%3e\u003cimg src=#\u003e\\x3cimg\\x3e11";

//        StringEscapeUtils.escapeHtml(UnicodeUtil.toString(s1));
        System.out.println(StringEscapeUtils.escapeHtml3(UnicodeUtil.toString(s1)));
        System.out.println(UnicodeUtil.toString(s2));
        System.out.println(UnicodeUtil.toString(s3));
        System.out.println(UnicodeUtil.toString(s4));
    }
}
