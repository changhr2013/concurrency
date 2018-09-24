package com.changhr.concurrency.example.singleton;

import com.changhr.concurrency.annoations.NotThreadSafe;
import com.changhr.concurrency.annoations.Recommend;
import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式 >> 双重检测同步锁机制
 * 单例实例在第一次使用时创建
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample5 {

    // 私有的构造函数
    private SingletonExample5() {
    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存

    // 单例对象  volatile + 双重检测机制 -> 禁止指令重排
    private static volatile SingletonExample5 singletonExample1 = null;

    // 静态的工厂方法
    public static SingletonExample5 getInstance(){
        // 双重检测机制
        if(singletonExample1 == null){
            // 同步锁
            synchronized (SingletonExample5.class){
                if(singletonExample1 == null){
                    singletonExample1 = new SingletonExample5();
                }
            }

        }
        return singletonExample1;
    }
}
