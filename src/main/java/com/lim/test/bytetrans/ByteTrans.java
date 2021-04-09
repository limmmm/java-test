package com.lim.test.bytetrans;

import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Lim
 * @since 2021/3/17
 */
@Slf4j
public class ByteTrans {


    public static void main(String[] args) throws IOException {

//        write2File();

        String hex = "0d0a";
        log.info("hex: {}, byte: {}, short: {}", hex, hexToByteArray(hex), byte2String(hexToByteArray(hex)));

/*        String hex = "03c4";
        log.info("hex: {}, byte: {}, short: {}", hex, hexToByteArray(hex), byte2short(hexToByteArray(hex)));
        String hex2 = "03ac";
        log.info("hex: {}, byte: {}, short: {}", hex2, hexToByteArray(hex2), byte2short(hexToByteArray(hex2)));
        String hex3 = "037c";
        log.info("hex: {}, byte: {}, short: {}", hex2, hexToByteArray(hex3), byte2short(hexToByteArray(hex3)));*/

//        byte[] b1 = new byte[] {36, 2, 4, 12, -128, -112, 100, -11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

//        System.out.println(Arrays.toString(b));
//        System.out.println(byte2String(b));

//        findMultitrans();
//        byte[] b0 = new byte[10];
//        log.info("{}", b0.length);

//        byte[] b1 = new byte[] {36, 2, 4, 12, -128, -112, 100, -11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        log.info("length: {}, str: {}", b1.length, byte2String(b1));
//        log.info("hex : {}", byteArrayToHex(b1));

        // sendLen
//        byte[] b2 = new byte[] {3, -12};
//        log.info("byte: {}, short: {}", b2, byte2short(b2));

        // sendLen
//        byte[] b21 = new byte[] {4, 12};
//        log.info("byte: {}, short: {}", b21, byte2short(b21));

        // sendLen
//        byte[] b22 = new byte[] {3, -36};
//        log.info("byte: {}, short: {}", b22, byte2short(b22));

        // 4 - 5
//        byte[] b3 = new byte[] {-128, -112};
//        log.info("byte: {}, int: {}", b3, byte2short(b3));

        // rtpCnt
//        byte[] b4 = new byte[] {72, 87};
//        log.info("byte: {}, int: {}", b4, byte2short(b4));
    }

    static void findMultitrans() {
        String hexStr = "7cb59b432201000912002025080045000125249b40004006908fc0a801f1c0a80167e314e64c7cb3bc2ce25447bd50180708ca4a00004d554c54495452414e5320727473703a2f2f3139322e3136382e312e3130332f6d756c74697472616e7320525453502f312e300a435365713a20310d0a436f6e74656e742d547970653a206170706c69636174696f6e2f6a736f6e0d0a436f6e74656e742d4c656e6774683a203133370d0a0d0a7b2274797065223a2272657175657374222c2022736571223a302c2022706172616d73223a207b226d6574686f64223a22646f222c22617564696f5f636170747572655f6d756c74697472616e735f636f6e6e656374223a7b2273657373696f6e5f6964223a22383135333238343939222c22757365725f74797065223a22646576696365227d7d7d";
        byte[] b = hexToByteArray(hexStr);
        System.out.println(Arrays.toString(b));
        byte[] multitrans = "MULTITRANS ".getBytes();
        System.out.println(b[0]);
        System.out.println(multitrans[0]);
        System.out.println(Arrays.toString(multitrans));
        int index = -1;
        int i = Arrays.binarySearch(b, multitrans[0]);
        System.out.println(i);
    }

    static void write2File() throws IOException {
        byte[] b = new byte[] {36, 2, 4, 12, -128, -112, 100, -11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        BufferedWriter out = new BufferedWriter(new FileWriter("D:/a"));
        String filePath = "D:/out";
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath, true));
        out.write(b);
        String newLine = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        out.write(newLine.getBytes());
        out.write(b);
        out.close();
    }

    static String byteArrayToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int index = 0, len = bytes.length; index <= len - 1; index += 1) {
            int char1 = ((bytes[index] >> 4) & 0xF);
            char chara1 = Character.forDigit(char1, 16);
            int char2 = ((bytes[index]) & 0xF);
            char chara2 = Character.forDigit(char2, 16);
            result.append(chara1);
            result.append(chara2);
        }
        return result.toString();
    }


    public static byte[] hexToByteArray(String inHex){
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){
            //奇数
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex="0"+inHex;
        }else {
            //偶数
            result = new byte[(hexlen/2)];
        }
        int j=0;
        for (int i = 0; i < hexlen; i+=2){
            result[j]=hexToByte(inHex.substring(i,i+2));
            j++;
        }
        return result;
    }


    public static byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex,16);
    }

    public static String byte2String(byte[] b) {
        return new String(b, StandardCharsets.UTF_8);
    }

    public static byte[] short2byte(short s) {
        byte[] b = new byte[2];
        IntStream.range(0, 2).forEach(i -> {
            //因为byte占4个字节，所以要计算偏移量
            int offset = 16 - (i + 1) * 8;
            //把16位分为2个8位进行分别存储
            b[i] = (byte) ((s >> offset) & 0xff);
        });
        return b;
    }

    public static short byte2short(byte[] b){
        short l = 0;
        for (int i = 0; i < 2; i++) {
            l<<=8;
            l |= (b[i] & 0xff);
        }
        return l;
    }

    public static byte[] int2byte(int s){
        byte[] b = new byte[2];
        for(int i = 0; i < 4; i++){
            int offset = 16 - (i+1)*8;
            b[i] = (byte)((s >> offset)&0xff);
        }
        return b;
    }


    public static int byte2int(byte[] b){
        int l = 0;
        for (int i = 0; i < 4; i++) {
            l<<=8;
            l |= (b[i] & 0xff);
        }
        return l;
    }

}
