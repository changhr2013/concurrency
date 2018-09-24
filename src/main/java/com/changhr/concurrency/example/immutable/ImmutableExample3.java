package com.changhr.concurrency.example.immutable;

import com.changhr.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
public class ImmutableExample3 {

    private static final ImmutableList list = ImmutableList.of(1, 2, 3);

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

    private static final ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private static final ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1,2)
            .put(3,4)
            .build();

    public static void main(String[] args) {
//        list.add(4);
//        set.add(4);
//        map.put(5, 6);
//        map2.put(5, 6);

        System.out.println(map2.get(3));


    }
}
