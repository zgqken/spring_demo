package com.ken.jvm;

/**
 * 类名称：
 * 类描述： VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 创建人：zgquan
 * 创建日期：2017/7/19
 */
public class EdenMinorGC {

    private static final int _1MB=1024*1024;

    public static void main(String[] args) {
        byte[] a1,a2,a3,a4;
        a1=new byte[2*_1MB];
        a2=new byte[2*_1MB];
        a3=new byte[2*_1MB];
        a4=new byte[4*_1MB];//出现一次Minor GC
    }
}
