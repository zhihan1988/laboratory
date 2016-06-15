package rpc;

/**
 * Created by liuzhihan on 2016/6/15.
 */
public class EchoServiceImpl implements EchoService {

    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }
}
