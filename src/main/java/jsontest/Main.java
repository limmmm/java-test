package jsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: Lim
 * @date: 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        array.add(null);
        array.add(null);
        array.add(new JSONObject());

        JsonTest test1 = new JsonTest(1,"1");
        JsonTest test2= new JsonTest(2,"2");
        array.add(JSON.toJSON(test1));
        array.add(JSON.toJSON(test2));
        System.out.println(array);
    }
}
