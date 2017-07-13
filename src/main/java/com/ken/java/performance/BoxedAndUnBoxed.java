package com.ken.java.performance;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/10 0010
 */
public class BoxedAndUnBoxed {

    public static void main(String[] args) {
        badPractic();
        bestPractic();
    }


    public static void badPractic(){
        long begin = System.currentTimeMillis();
        Long num = null;
        for (int i=1;i<10000000;i++){
           num=num==null?0:num;
        }

        System.out.println("bad："+(System.currentTimeMillis()-begin));
    }


    public static void bestPractic() {
        long begin = System.currentTimeMillis();
        Long num = null;
        for (int i = 1; i < 10000000; i++) {
            num= num== null ? Long.valueOf(0) : num;
        }
        System.out.println("good：" + (System.currentTimeMillis() - begin));
    }
}
