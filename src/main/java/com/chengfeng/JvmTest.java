package com.chengfeng;

/**
 * Created by chengfeng on 2016/8/26.
 */
public class JvmTest {

    public static void main(String[] args) {
        //new CpuThread().start();
        //new FileThread().start();
        //new KafkaThread().start();
        new MemoryThread().start();

        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {

        }
    }
}
