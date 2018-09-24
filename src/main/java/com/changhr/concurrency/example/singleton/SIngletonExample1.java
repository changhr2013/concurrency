package com.changhr.concurrency.example.singleton;

import com.changhr.concurrency.annoations.NotRecommend;
import com.changhr.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例实例在第一次使用时创建
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class SingletonExample1 {

    // 私有的构造函数
    private SingletonExample1() {
    }

    // 单例对象
    private static SingletonExample1 singletonExample1 = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(singletonExample1 == null){
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }
}
