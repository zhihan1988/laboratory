package singleton;

/**
 * Created by liuzhihan on 2018/1/18.
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){};
    public static InnerClassSingleton getInstance(){
        return SingletonHolder.instance;
    }
    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();

    }
}
