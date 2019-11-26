package httptest;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @author Lim
 * @date 2019/11/26
 */
public class Test {
    public static void main(String[] args) {
        for(int i=0; i<1; i++) {
            String result1= HttpUtil.get("http://minisite.medtoday.com.cn/cycle/wechat/configforlive/wxconfig.php?url=http%3A%2F%2Fminisite.medtoday.com.cn%2FH5%2F1127poa%2Findex.html");
            JSONObject re = JSONObject.parseObject(result1);
            String key = re.getJSONObject("signPackage").getString("signature");
            System.out.println(key);

            String url = "http://minisite.medtoday.com.cn/cycle/v-dmkang-physician/updatefileupqtybyfileid.php";
            for(int j=0; j<300; j++) {
                String u = String.format("http://minisite.medtoday.com.cn/cycle/v-dmkang-physician/updatefileupqtybyfileid.php?file_id=565&user_id=%s&user_type_id=1", key);

                HashMap<String, Object> paramMap = new HashMap<>();
                paramMap.put("file_id", "565");
                paramMap.put("user_id", "81b2fff4103111ea8bd500163e0c87ad104615");
                paramMap.put("user_type_id", "1");

                String result = HttpUtil.post(url, paramMap);
                System.out.println(result);

//                String result= HttpRequest.post(u).execute().body();
//                System.out.println(result);
            }
        }
    }
}
