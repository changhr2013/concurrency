package com.changhr.concurrency.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 不可变对象: final
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
public class ImmutableExample1 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        // a = 2; X
        // b = "3"; X
        // map = Maps.newHashMap(); X

        // final 修饰引用类型，里面的值是可以修改的，只是对象不能指向另外的对象
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
        // a = 1; X
        // final 修饰的参数不能修改
    }
}
