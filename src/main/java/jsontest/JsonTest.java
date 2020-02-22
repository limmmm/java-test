package jsontest;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lim
 * @date: 2019/8/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonTest {
    @JSONField(name = "c")
    private int a;

    @JSONField(name = "d")
    private String b;
}
