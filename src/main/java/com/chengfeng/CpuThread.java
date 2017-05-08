package com.chengfeng;

/**
 * CPU计算型线程
 * @author chengfeng on 2016/8/26.
 */
public class CpuThread extends Thread {

    public CpuThread() {
        super("CpuThread");
    }

    @Override
    public void run() {
        double a = 2442.824;
        double b = 92492489.24942;
        double c = 248.82498;
        long counter = 0;
        while(true) {
            a = a + 293.23;
            double result = a * b * a / c / (a + c);
            System.out.println(result);
            if(counter++ % 1000 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
