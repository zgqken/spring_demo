package com.ken.java8;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author：davy(888032)
 * @date：2018/3/23
 * @since
 */
public class StreamTest {


    @Test
    public void test() {
        List<Integer> name = map().stream()
                .map(Apple::getColor)
                .map(String::length)
                .distinct()
                .collect(toList());
        System.out.println(JSONObject.toJSON(name));
    }

    @Test
    public void flagMapTest() {
        List<Integer> num1 = Lists.newArrayList(1, 2, 3);
        List<Integer> num2 = Lists.newArrayList(4, 5);
        List<int[]> pairs = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j})).collect(toList());
        System.out.println(JSONObject.toJSON(pairs));

    }


    public static List<Apple> map() {
        BiFunction<String, Integer, Apple> create = Apple::new;
        List<Apple> list = Lists.newArrayList();
        list.add(create.apply("red", 11));
        list.add(create.apply("green", 12));
        list.add(create.apply("yellow", 13));
        list.add(create.apply("red", 14));
        list.add(create.apply("green", 15));
        list.add(create.apply("yellow", 16));
        list.add(create.apply("red", 17));
        list.add(create.apply("green", 18));
        return list;
    }

    public static List<Apple> map2() {
        BiFunction<String, Integer, Apple> create = Apple::new;
        List<Apple> list = Lists.newArrayList();
        list.add(create.apply("red", 21));
        list.add(create.apply("green", 22));
        list.add(create.apply("yellow", 23));
        list.add(create.apply("red", 24));
        list.add(create.apply("green", 25));
        list.add(create.apply("yellow", 26));
        list.add(create.apply("red", 27));
        list.add(create.apply("green", 28));
        return list;
    }

    @Test
    public void create() {

        BiFunction<String, Integer, Apple> create = Apple::new;
        Apple apple = create.apply("green", 12);
    }


    @Test
    public void gougushu() {
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}
                                ).filter(t -> t[2] % 1 == 0)
                        );
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

    }

    @Test
    public void groupBy() {
        Map<String, List<Apple>> map = map().stream().
                collect(Collectors.groupingBy(Apple::getColor));

        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void flatMap() {
        List<List<String>> lists = Lists.newArrayList(Lists.newArrayList("a", "b"), Lists
                .newArrayList("c", "d"));
        List<String> flatMapList = lists.stream().flatMap(list -> list.stream()).collect(toList());
        System.out.println(JSONObject.toJSONString(flatMapList));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Apple {

    private String color;

    private Integer weight;

}