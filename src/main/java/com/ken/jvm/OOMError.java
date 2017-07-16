package com.ken.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：
 * 类描述：VM Args: -Xms 20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 创建人：zgquan
 * 创建日期：2017/7/13
 */
public class OOMError {


    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
