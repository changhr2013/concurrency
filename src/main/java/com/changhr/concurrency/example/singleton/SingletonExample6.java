package com.changhr.concurrency.example.singleton;

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
public class SingletonExample6 {

    // 私有的构造函数
    // 1. 饿汉模式保证私有构造函数在构造的时候没有太多的处理
    // 2. 保证这个类在实际中肯定会被使用，保证不会产生资源的浪费
    private SingletonExample6() {
    }

    // 静态代码块和静态变量的顺序不能颠倒，他们会按书写的先后顺序执行
    // 单例对象
    private static SingletonExample6 singletonExample1 = null;

    static{
        singletonExample1 = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance(){
        return singletonExample1;
    }
}
