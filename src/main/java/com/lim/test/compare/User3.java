package com.lim.test.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

/**
 * 继承{@link Comparator}, 重写 {@link Comparator#compare(Object, Object)}
 * @author lim
 * @since 2021-01-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User3 implements Comparator<User3> {
    private Integer id;

    private Integer age;

    @Override
    public int compare(User3 a, User3 b) {
        if (a.getId().equals(b.getId())) {
            return a.getAge().compareTo(b.getAge());
        }
        return a.getId().compareTo(b.getId());
    }

}
