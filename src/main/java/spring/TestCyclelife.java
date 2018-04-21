package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring的生命周期
 */
public class TestCyclelife {

    public static void main(String[] args){
        System.out.println("--------------【初始化容器】---------------");
        //配置文件必须放置在资源目录？放在java文件夹下面居然不会被拷贝到编译文件夹下面
        //本来为了省事想把beans.xml直接放置在java/spring/beans.xml但是读取的时候是找不到配置文件的 原因如上
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans.xml");
        System.out.println("-------------------【容器初始化成功】------------------");
        //得到studentBean，并显示其信息
        StudentBean studentBean = context.getBean("studentBean",StudentBean.class);
        System.out.println(studentBean);
        System.out.println("--------------------【销毁容器】----------------------");
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();
    }
}
