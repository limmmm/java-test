package com.lim.test.bytetrans;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Li Ming
 * @mail liming@tp-link.com.cn
 * @since 2021/3/18
 */
@Slf4j
public class ByteBufTest {
    public static void main(String[] args) {
        Map<String, Boolean> map = new ConcurrentHashMap<>();
        map.put("a", false);
        Boolean t = map.remove("a");
        log.info("t: {}", t);
        log.info("map: {}", map);

        byte[] a = new byte[] {1, 2};

        ByteBuf heapBuf = Unpooled.buffer(5, 10);
        heapBuf.writeBytes(a);
        heapBuf.writeByte((byte) 3);
        heapBuf.writeByte((byte) 4);
        heapBuf.writeByte((byte) 5);
        heapBuf.writeByte((byte) 6);
        log.info("length1: {}", heapBuf.readableBytes());
        log.info("{}", heapBuf.array());
        log.info("b: {}", heapBuf.readByte());
        log.info("b: {}", heapBuf.readByte());
        log.info("length2: {}", heapBuf.readableBytes());

        byte[] all = new byte[heapBuf.readableBytes()];
        heapBuf.readBytes(all);
        log.info("all: {}", all);

        heapBuf.discardReadBytes();
        heapBuf.writeByte((byte) 7);
        heapBuf.writeByte((byte) 8);
        heapBuf.writeByte((byte) 9);
        heapBuf.writeByte((byte) 9);
        heapBuf.writeByte((byte) 9);
        heapBuf.writeByte((byte) 9);
        log.info("length3: {}", heapBuf.readableBytes());

        log.info("b: {}", heapBuf.readByte());
        log.info("b: {}", heapBuf.readByte());
        log.info("length4: {}", heapBuf.readableBytes());

        heapBuf.discardReadBytes();
        byte[] bytes = new byte[3];
        heapBuf.getBytes(0, bytes);
        log.info("getBytes: {}", bytes);
        log.info("length5: {}", heapBuf.readableBytes());

        bytes = new byte[3];
        heapBuf.readBytes(bytes);
        log.info("bytes: {}", bytes);
        log.info("b: {}", heapBuf.readByte());
        log.info("b: {}", heapBuf.readByte());
        log.info("b: {}", heapBuf.readByte());
        heapBuf.clear();
//        heapBuf.
        heapBuf.release();
//        heapBuf.discardReadBytes();
        log.info("{}", heapBuf.array());
//        log.info("b: {}", heapBuf.readByte());
//        log.info("b: {}", heapBuf.readByte());
        log.info("length5: {}", heapBuf.readableBytes());

        heapBuf.writeByte((byte) 10);
        heapBuf.writeByte((byte) 11);
        log.info("length6: {}", heapBuf.readableBytes());
        log.info("{}", heapBuf.array());
        bytes = new byte[3];
        heapBuf.getBytes(0, bytes);
        log.info("bytes: {}", bytes);



    }

    public static void main1(String[] args) {
        byte[] a = new byte[] {1, 2};
        ByteBuffer buffer = ByteBuffer.allocate(10);
        print(buffer);
        buffer.put(a);
        print(buffer);
        buffer.put((byte) 3);
        buffer.put((byte) 4);
        print(buffer);

        buffer.flip();
        print(buffer);
        byte b1 = buffer.get();
        byte b2 = buffer.get();
        log.info("get: {}, {}", b1, b2);
        print(buffer);

        buffer.flip();
        print(buffer);
        buffer.put((byte) 3);
        buffer.put((byte) 4);
//        buffer.put((byte) 5);
//        buffer.put((byte) 6);
//        buffer.put((byte) 7);
//        buffer.put((byte) 8);
        print(buffer);

        buffer.flip();
        b1 = buffer.get();
        b2 = buffer.get();
        log.info("get: {}, {}", b1, b2);
    }

    private static void print(ByteBuffer buffer) {
        log.info("limit: {}, capacity: {}, mark: {}, position: {}", buffer.limit(),
                buffer.capacity(), buffer.mark(), buffer.position());
        log.info("{}", buffer.array());
    }

    private static void get(ByteBuffer buffer) {

    }
}
