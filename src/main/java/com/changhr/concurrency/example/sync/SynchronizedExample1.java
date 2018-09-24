package com.changhr.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Synchronized 修饰代码块
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
public class SynchronizedExample1 {

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizedExample1.test2(1);
        });
        executorService.execute(() -> {
            synchronizedExample2.test2(2);
        });
    }

    // Synchronized 修饰代码块, 作用于调用对象
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} --> {}", j, i);
            }
        }
    }

    // Synchronized 修饰方法，作用于调用对象
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} --> {}", j, i);
        }
    }
}
