package com.ken.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：
 * 类描述：VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 创建人：zgquan
 * 创建日期：2017/7/13
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
