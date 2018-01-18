package singleton;

/**
 * Created by liuzhihan on 2018/1/18.
 */
public enum EnumSingleton {
    INSTANCE;
    public void print(){
        System.out.println("hello ~");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.print();
    }
}
