package com.lim.test.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 继承{@link Comparable}, 重写{@link Comparable#compareTo(Object)}
 * @author lim
 * @since 2021-01-08
 */
@Data
@AllArgsConstructor
public class User2 implements Comparable<User2> {
    private Integer id;

    private Integer age;

    @Override
    public int compareTo(User2 u) {
        if (id.equals(u.getId())) {
            return age.compareTo(u.getAge());
        }
        return id.compareTo(u.getId());
    }

}
