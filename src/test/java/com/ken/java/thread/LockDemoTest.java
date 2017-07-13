package com.ken.java.thread;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/4 0004
 */
@DisplayName("lockDemo")
public class LockDemoTest {

    @Test
    public void LockBaseTest() {

        final LockDemo test = new LockDemo();
        Runnable taskA = ()-> test.insert(Thread.currentThread().getName());
        Runnable taskB = ()-> test.insert(Thread.currentThread().getName());

        new Thread(taskA).start();
        new Thread(taskB).start();

    }

    @Test
    public void tryLockInsert(){
        final LockDemo test = new LockDemo();
        Runnable taskA = () -> test.tryLockInsert(Thread.currentThread().getName());
        Runnable taskB = () -> test.tryLockInsert(Thread.currentThread().getName());

        new Thread(taskA).start();
        new Thread(taskB).start();

    }



}
