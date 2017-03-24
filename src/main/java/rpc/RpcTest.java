package rpc;

import java.net.InetSocketAddress;

/**
 * 本地scf客户端对接口类产生代理 调用接口方法的时候实际上是把接口名 方法 参数 进行序列化 然后通过socket等方式发送到远程服务器
 * 远程服务器接收参数后反序列化为对象 并对其进行反射调用 然后返回执行结果
 * socket 序列化 反射
 * Created by liuzhihan on 2016/6/15.
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8765);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8765));
        System.out.println(echo.echo(" Are you ok ?"));
    }
}
