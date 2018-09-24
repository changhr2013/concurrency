package com.changhr.concurrency.example.immutable;

import com.changhr.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 不可变对象
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        // throw Exception: java.lang.UnsupportedOperationException
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
