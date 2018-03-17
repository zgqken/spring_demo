package com.ken.javase.design_pattern.adapter;

/**
 * 类名称：
 * 类描述：类适配器
 * 创建人：zgquan
 * 创建日期：2017/7/1
 */
public class ClassAdapterDemo {

    public static void main(String[] args) {
        TagetC taget = new AdapterC();
        taget.request();
        AdapteeC adapteeC = new AdapterC();
    }
}

//可以是接口、抽象类、实体类
interface TagetC {
    public void request();
}

class AdapteeC {
    public void specificRequest(){
    }
}

class AdapterC extends AdapteeC implements TagetC {

    @Override
    public void request() {
        specificRequest();
    }

    @Override
    public void specificRequest() {

    }
}