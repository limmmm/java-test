package regex;

/**
 * @author: Lim
 * @date: 2019/8/16
 */
public class Main {
    public static void main(String[] args) {
        String s = "INSERT INTO templete_msg (id, code, type, content, comment, status, create_time, update_time, create_uid, update_uid) VALUES ('3c983874b82111e9949f286ed488c6b7', 'SS_SMS', 2, '【政务短信平台】【广东省政务大数据中心】${dep}的$name，您有一个数据共享需求实施任务已超时，请尽快处理。点击进入处理：$url', '实施-短信提醒模板', 1, '2019-08-06 16:07:30.000', null, null, null);";
        s = s.replaceAll("[{]dep[}]", "1").replaceAll("$name","cn").replaceAll("$url", "http");
        System.out.println(s);
    }

}
