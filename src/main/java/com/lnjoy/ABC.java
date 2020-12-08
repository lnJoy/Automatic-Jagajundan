package com.lnjoy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ABC extends Thread {
    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        String now = null;
        while(true) {
            try {
                Date nowTime = new Date();
                now = format.format(nowTime);
                if(now.equals("07:00")) {
                    System.out.println(now + ", Start!!");
                    new ABX();
                    Thread.sleep(60000);
                }
                System.out.println("현재 시각 - " + now);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
