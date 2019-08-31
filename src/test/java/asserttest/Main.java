package asserttest;

import org.springframework.util.Assert;

/**
 * Lim
 * 2019/8/8
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("aaaa");
//        Assert.state(false, "Main assert false");
        System.out.println("bbbb");

        System.out.println("cccc");
        A a = new A();
        a.test();
        Assert.state(false, "Main assert false");
        System.out.println("ddddd");
    }
}
