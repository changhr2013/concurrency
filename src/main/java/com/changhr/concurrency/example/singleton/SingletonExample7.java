package com.changhr.concurrency.example.singleton;

import com.changhr.concurrency.annoations.Recommend;
import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式：最安全的写法
 * 单例实例在类装载时创建
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singletonInstance;

        // JVM保证这个方法绝对只被调用一次
        Singleton() {
            singletonInstance = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singletonInstance;
        }
    }

    // 静态的工厂方法
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}
