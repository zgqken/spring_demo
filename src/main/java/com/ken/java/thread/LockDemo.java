package com.ken.java.thread;


import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/4 0004
 */
public class LockDemo {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();  // 注意这个地方:lock被声明为成员变量

    public void insert(String threadName) {

        lock.lock();
        try {
            System.out.println("线程" + threadName + "得到了锁...");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {

        } finally {
            System.out.println("线程" + threadName + "释放了锁...");
            lock.unlock();
        }
    }

    public void tryLockInsert(String threadName){

        if (lock.tryLock()) {     // 使用 tryLock()
            try {
                System.out.println("线程" + threadName + "得到了锁...");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {

            } finally {
                System.out.println("线程" + threadName + "释放了锁...");
                lock.unlock();
            }
        } else {
            System.out.println("线程" + threadName + "获取锁失败...");
        }

    }
}
