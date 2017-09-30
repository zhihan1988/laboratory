/**
 * 方法传递是对象的引用 但是方法内部在接收这个引用的时候是用一个局部变量进行存储的
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
