package com.changhr.concurrency.example.publish;

import com.changhr.concurrency.annoations.NotRecommend;
import com.changhr.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author changhr2013
 * @create 2018/9/24
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
