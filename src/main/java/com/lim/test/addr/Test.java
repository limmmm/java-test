package com.lim.test.addr;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 父类/子类地址转化测试
 *
 * @author lim
 * @since 2020-12-03
 */
@Slf4j
public class Test {

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;

    public static void main(String[] args) {
        String s = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx1709194971408571dbd9fc22a640af0000&package=1798140044&redirect_url=https://192.168.1.122:8888";
        String rs = Arrays.stream(s.split("&")).filter(e -> !e.contains("redirect_url")).collect(Collectors.joining(
                "&"));
        System.out.println(rs);

    }


    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last) {
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    } else {
                        System.out.print(", -" + Long.toHexString( last - i2));
                    }
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

}
