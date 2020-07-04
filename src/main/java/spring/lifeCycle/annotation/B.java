package spring.lifeCycle.annotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * bean的生命周期 1.扫描 2.类的信息缓存到beanDefinisionMap 3.遍历这个map 4.验证    抽象 单例 懒加载等 5. 通过BeanDefinition 得到类的class 6. 根据类推断构造函数方法
 * 反射实例化一个对象 7. 提前暴露一个工厂 singletonFactories(为了解决循环依赖) 8. 属性注入 populateBean- AutowiredAnnotationBeanPostProcessor 9.
 * 调用aware接口 10. 调用生命周期(lifecycle)初始化回调方法 11. 完成代理 AOP 12. 放到单例池 singletonObjects
 * <p>
 * 主要路径 abstractApplicationContext.refresh => finishBeanFactoryInitialization => getBean =>
 * abstractBeanFactory.doGetBean => getSingleton(beforeSingletonCreation) =>
 * AbstractAutowireCapableBeanFactory#creatBean
 * => doCreateBean => populateBean（包含IOC） => initializeBean(包含AOP)
 *
 * @author bailong
 * @date 2020/6/25
 */
@Component
public class B implements BeanNameAware {
    /**
     * 2.populateBean- AutowiredAnnotationBeanPostProcessor
     */
    @Autowired
    A a;

    /**
     * 1.org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean=>createBeanInstance
     */
    public B() {
        System.out.println("construct B");
    }

    /**
     * 3.org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#initializeBean=>invokeAwareMethods
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("beanNameAware B");
    }

    /**
     * 4.生命周期初始化回调方法 也可以在@Bean 指定initMethod  或者xml中指定initMethod   再或者实现InitializingBean
     * .afterPropertiesSet（这种方法spring官方不建议使用） 4.org.springframework.beans.factory.support
     * .AbstractAutowireCapableBeanFactory#initializeBean=>applyBeanPostProcessorsBeforeInitialization
     */
    @PostConstruct
    public void beanPostConstruct() {
        System.out.println("post Construct B");
    }

    //5. aop
    //6. 添加到bean单例池（singletonObjects）
}
