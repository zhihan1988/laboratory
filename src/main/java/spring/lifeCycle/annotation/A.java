package spring.lifeCycle.annotation;

import org.springframework.stereotype.Component;

/**
 * @author bailong
 * @date 2020/6/25
 */
@Component
public class A {
    public A() {
        System.out.println("construct A");
    }
}
