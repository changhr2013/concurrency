package com.changhr.concurrency.example.atomic;

import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Atomic 包中的 AtomicInterFieldUpdater
 * Atomic 包中的 AtomicInterFieldUpdater
 * 用来更新某个类中的 【非 static 并且是 volatile】的字段
 *
 * @author changhr2013
 * @create 2018/9/23
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();

        if(updater.compareAndSet(atomicExample5, 100, 120)){
            log.info("updater success 1 --> {}", atomicExample5.getCount());
        }
        if(updater.compareAndSet(atomicExample5, 100, 120)){
            log.info("updater success 2 --> {}", atomicExample5.getCount());
        } else {
            log.info("updater failed --> {}", atomicExample5.getCount());
        }
    }
}
