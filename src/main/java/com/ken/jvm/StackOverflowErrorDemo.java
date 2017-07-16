package com.ken.jvm;

/**
 * 类名称：
 * 类描述：VM Args: -Xss128k
 * 创建人：zgquan
 * 创建日期：2017/7/13
 */
public class StackOverflowErrorDemo {

    private int stackLength =1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverflowErrorDemo demo = new StackOverflowErrorDemo();
        try {
            demo.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+demo.stackLength);
            throw e;
        }

    }
}
