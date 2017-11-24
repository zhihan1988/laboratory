/**
 * 方法传递是对象的引用 但是方法内部在接收这个引用的时候是用一个局部变量进行存储的
 * 所以在方法里面改变u的引用不会影响原来的引用。
 *
 * 重点解析下2： 首先u是指向一块地址，我们暂且叫做A，在没有调用方法前，u指向A ，调用方后，把u传进去当参数，相当于吧u的地址复制了一份给c，把c传给方法，在方法中有一个u1赋给了c，那么现在 c指向了u1指向的地址，暂且叫B，现在来看 main方法中的u还是指向运来的A，而传进来的副本c却指向了B，这就是原委
 * Created by liuzhihan on 2017/9/30.
 */
public class ChangeUserName {


    //更改user中name的方法
    public static void replaceName1(User u){
        //1
        u.setUserName("bbb");
    }

    public static void replaceName2(User u){
        //2
        User u1 = new User();
        u1.setUserName("bbb");
        u = u1;
    }

    public static void replaceName3(User u){
        //3
        User u1=u;
        u1.setUserName("bbb");
    }

    //调用函数更改user中的username
    public static void main(String args[]){
        User user1 = new User();
        user1.setUserName("aaa");
        replaceName1(user1);
        System.out.println(user1.getUserName());

        User user2 = new User();
        user2.setUserName("aaa");
        replaceName2(user2);
        System.out.println(user2.getUserName());

        User user3 = new User();
        user3.setUserName("aaa");
        replaceName3(user3);
        System.out.println(user3.getUserName());
    }


    static class User{
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }




}
