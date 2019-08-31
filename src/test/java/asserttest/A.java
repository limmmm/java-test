package asserttest;

import org.springframework.util.Assert;

/**
 * Lim
 * 2019/8/8
 */
public class A {
    
    public void test() {
        System.out.println("A.test aaaa");
        Assert.state(false, "assert A.test failed");
        System.out.println("A.test bbbb");
    }
}
