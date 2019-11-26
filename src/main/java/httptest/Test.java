package httptest;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Lim
 * @date 2019/11/26
 */
public class Test {
    public static void main(String[] args) {


        for(int t=0; t < 100000; t++) {
            long time = System.currentTimeMillis();
            System.out.println(time);

            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("zone", "国内");
            paramMap.put("telephone", "1234567890");
            paramMap.put("name", "游客" + time);

            String url = "http://minisite.medtoday.com.cn/cycle/v-dmkang-physician/user_register.php";
            String result = HttpUtil.post(url, paramMap);
            JSONObject rj = JSONObject.parseObject(result);
            JSONObject user = (JSONObject) rj.getJSONArray("user").get(0);
            String userId = user.getString("user_id");
            System.out.println(userId);

            for(int i=0; i<10; i++) {
                String url_vote = "http://minisite.medtoday.com.cn/cycle/v-dmkang-physician/updatefileupqtybyfileid.php";
                HashMap<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("file_id", "565");
                paramMap2.put("user_id", userId);
                paramMap2.put("user_type_id", "1");
                String result2 = HttpUtil.post(url_vote, paramMap);
                System.out.println(result2);
            }

//            int k=5000;
//            while(k-- > 0){
//
//            };
//            long s = 100;
//            Thread.sleep(s);
        }


        /*for(int i=0; i<1; i++) {
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
        }*/
    }
}
