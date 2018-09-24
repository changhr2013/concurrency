package com.changhr.concurrency.example.singleton;

import com.changhr.concurrency.annoations.NotRecommend;
import com.changhr.concurrency.annoations.NotThreadSafe;
import com.changhr.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例实例在第一次使用时创建
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有的构造函数
    private SingletonExample3() {
    }

    // 单例对象
    private static SingletonExample3 singletonExample1 = null;

    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(singletonExample1 == null){
            singletonExample1 = new SingletonExample3();
        }
        return singletonExample1;
    }
}
