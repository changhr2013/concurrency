package com.changhr.concurrency;

import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Synchronized保证线程安全
 * @author changhr2013
 * @create 2018/9/23
 */
@Slf4j
@ThreadSafe
public class ConcurrencyTest {

    /** 请求总数 */
    public static int clientTotal = 5000;

    /** 同时并发执行的线程数 */
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    // 判断当前进程是否允许被执行
                    semaphore.acquire();
                    add();
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
        log.info("count --> {}", count);

    }

    private static synchronized void add(){
        count ++;
    }
}
