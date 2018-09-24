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
public class SynchronizedExample2 {

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizedExample1.test1(1);
        });
        executorService.execute(() -> {
            synchronizedExample2.test1(2);
        });
    }

    // Synchronized 修饰类，作用于类的所有对象
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} --> {}", j, i);
            }
        }
    }

    // Synchronized 修饰静态方法，作用于类的所有对象
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} --> {}", j, i);
        }
    }
}
