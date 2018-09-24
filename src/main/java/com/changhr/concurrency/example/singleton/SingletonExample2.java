package com.changhr.concurrency.example.singleton;

import com.changhr.concurrency.annoations.NotThreadSafe;
import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 单例实例在类装载时创建
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {

    // 私有的构造函数
    // 1. 饿汉模式保证私有构造函数在构造的时候没有太多的处理
    // 2. 保证这个类在实际中肯定会被使用，保证不会产生资源的浪费
    private SingletonExample2() {
    }

    // 单例对象
    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance(){
        return singletonExample1;
    }
}
