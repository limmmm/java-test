package hashtest;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Lim
 * @date 2020/6/8
 */

/**
 * @Data会重写 hashcode 算法，属性值相同，hashcode相等
 */
@Data
class User {
    @NonNull private String id;
    private String name;
    private Integer age;

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
