package com.ken.java.performance;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/10 0010
 */
public class MapForeach {


    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        init();
//        keyForEach();
//        entityForEach();
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test1");
        System.out.println(JSONObject.toJSONString(list));
    }


    public static void init(){
        for(int i=0;i<1000000;i++){
            map.put(i+"",i);
        }
    }

    public static void keyForEach(){
        long begin = System.currentTimeMillis();
        int i=0;
        for(String key:map.keySet()){
            i+=map.get(key);
        }
        System.out.println("bad:"+(System.currentTimeMillis()-begin));
    }
    public static void entityForEach(){
        long begin = System.currentTimeMillis();
        int i=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            i+=entry.getValue();
        }

        System.out.println("best:"+(System.currentTimeMillis()-begin));
    }


}
