package com.ken.java8;

import org.junit.Test;

/**
 * @author：davy(888032)
 * @date：2018/3/18
 * @since
 */
public class LambdaTest {

    @Test
    public void firstLambda(){
        Runnable r1 = ()-> System.out.println("hello test");
        r1.run();
    }



}
