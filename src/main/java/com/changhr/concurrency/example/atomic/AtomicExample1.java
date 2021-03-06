package com.changhr.concurrency.example.atomic;

import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic 包中的 AtomicInteger 类
 * @author changhr2013
 * @create 2018/9/23
 */
@Slf4j
@ThreadSafe
public class AtomicExample1 {

    /** 请求总数 */
    public static int clientTotal = 5000;

    /** 同时并发执行的线程数 */
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    // 判断当前进程是否允许被执行
                    semaphore.acquire();
                    atomicAdd();
                    // 释放当前进程
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception: --> {}", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count --> {}", count.get());

    }

    private static void atomicAdd(){
//        count.getAndIncrement();
        count.incrementAndGet();
    }
}
