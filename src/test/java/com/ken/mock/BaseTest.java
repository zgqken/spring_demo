package com.ken.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/26 0026
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseTest {

    @Mock
    private List list;

    @Test
    public void mockByAnnotation() {
        list.add(1);
        Mockito.verify(list).add(1);
    }

    @Test
    public void mockObject() {
        List<Integer> list = Mockito.mock(List.class);
        Mockito.when(list.add(anyInt())).thenReturn(true);
        list.add(1);
        Mockito.verify(list).add(1);
    }



}
