package com.lim.test.addr;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 子类
 *
 * @author lim
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Child extends Parent {

   private String name;

   private String sex;

}
