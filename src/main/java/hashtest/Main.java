package hashtest;

import java.util.Collections;
import java.util.Hashtable;

/**
 * @author Lim
 * @date 2020/6/8
 */
public class Main {

    public static void main(String[] args) {
        hash();
    }

    /**
     * 对象hash值
     * 对象属性值相同，hash值不同
     */
    private static void hash() {
        User user1 = new User("1", "name", 10);
        User user2 = new User("1", "name", 10);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
