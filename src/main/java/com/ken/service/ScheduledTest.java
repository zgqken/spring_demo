package com.ken.service;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zgquan(108563)
 * @date 2018/3/15 0015
 * @since
 */
//@Component
public class ScheduledTest {


    @Scheduled(fixedDelay = 5000)
    public void test1(){
        System.out.println("test1");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void test2(){
        System.out.println("test2");
    }

}
