package rpc;

import java.net.InetSocketAddress;

/**
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
