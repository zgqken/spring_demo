package com.ken.javase.design_pattern.adapter;

/**
 * 类名称：
 * 类描述：适配器设计模式(对象适配器)
 * 创建人：zgquan
 * 创建日期：2017/7/1
 */
public class ObjectAdapterDemo {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        //创建客户端需要调用的接口对象
        Target target = new Adapter(adaptee);
        //请求处理
        target.request();
    }
}

/**
 * 定义客户端使用的接口，与业务相关
 */
interface Target{
    //客户端请求处理的方法
    void request();
}

/**
 * 已经存在的接口，这个接口需要配置
 */
class Adaptee{
    //原本存在的方法
    public void specificRequest() {
        //业务代码
    }
}

/**
 * 适配器类
 */
class Adapter implements Target {
    /**
    * 持有需要被适配的接口对象
    */
    private Adaptee adaptee;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }

}