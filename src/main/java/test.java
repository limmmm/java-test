import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Lim
 * @date: 2019/8/21
 */
public class test {
    public static void main(String[] args) {
      String str = "{\n" +
              "  \"units\": [\n" +
              "    {\n" +
              "      \"extend\": {\n" +
              "        \"orgType\": \"7\",\n" +
              "        \"weworkpartyid\": [\n" +
              "          3344\n" +
              "        ]\n" +
              "      },\n" +
              "      \"isvirtual\": false,\n" +
              "      \"createtime\": \"2019-05-10T02:50:57.256Z\",\n" +
              "      \"parentunits\": [\n" +
              "        {\n" +
              "          \"unitid\": \"44a044e0-4cf6-11e8-85c3-45ad5e3a2bd7\",\n" +
              "          \"priority\": 1,\n" +
              "          \"order\": 99997989\n" +
              "        }\n" +
              "      ],\n" +
              "      \"unitpath\": [\n" +
              "        \"广东省/数字广东公司/测试部门/商务厅测试\"\n" +
              "      ],\n" +
              "      \"unitname\": \"商务厅测试\",\n" +
              "      \"unitid\": \"075kp0h8fqajk90msu3zqr\",\n" +
              "      \"updatetime\": \"2019-07-16T10:55:59.227Z\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"extend\": {\n" +
              "        \"orgType\": \"7\",\n" +
              "        \"weworkpartyid\": [\n" +
              "          118\n" +
              "        ]\n" +
              "      },\n" +
              "      \"isvirtual\": false,\n" +
              "      \"createtime\": \"2018-07-17T10:01:05.706Z\",\n" +
              "      \"parentunits\": [\n" +
              "        {\n" +
              "          \"unitid\": \"gkekpo3ystkxnseufgwn5a\",\n" +
              "          \"priority\": 1,\n" +
              "          \"order\": 99988994\n" +
              "        }\n" +
              "      ],\n" +
              "      \"unitpath\": [\n" +
              "        \"广东省/省政府/省政府办公厅/省政务服务数据管理局/测试部门\"\n" +
              "      ],\n" +
              "      \"unitname\": \"测试部门\",\n" +
              "      \"unitid\": \"9oyyed4rqwaljlcpwyyifw\",\n" +
              "      \"updatetime\": \"2019-07-16T10:54:09.962Z\"\n" +
              "    }\n" +
              "  ]\n" +
              "}";

        JSONObject json = JSONObject.parseObject(str);

        List units = (List) json.get("units");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("units", units);
        for (Object object : units) {
            Map temp = (Map) object;
            String unitid = (String) temp.get("unitid");
            String unitname = (String) temp.get("unitname");
            JSONArray unitArray = (JSONArray) temp.get("unitpath");
            String unitpath = unitArray.isEmpty() ? unitname:unitArray.get(0).toString();
            System.out.println(temp.toString());
            System.out.println(unitpath);
        }
    }
}
