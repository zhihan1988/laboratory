package pipeline;

/**
 * Created by liuzhihan on 2017/11/24.
 */
public class TestPipeLine {

    public static void main(String[] args) {
        MyPipeLine myPipeLine = new MyPipeLine();
        myPipeLine.addFirst(new ApplePipeLineHandler());
        myPipeLine.addFirst(new BananaPipeLineHandler());
        myPipeLine.request("fruit");
    }

}

class ApplePipeLineHandler implements PipeLineHandler{
    @Override
    public void handler(PipeLineHandlerContext context, Object result) {
        System.out.println("apple");
        context.write("apple");
    }
}


class BananaPipeLineHandler implements PipeLineHandler{
    @Override
    public void handler(PipeLineHandlerContext context, Object result) {
        System.out.println("banana");
        context.write("banana");
    }
}