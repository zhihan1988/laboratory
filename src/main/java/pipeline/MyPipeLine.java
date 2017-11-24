package pipeline;

/**
 * Created by liuzhihan on 2017/11/24.
 */
public class MyPipeLine {
    private PipeLineHandlerContext header;
    private PipeLineHandlerContext end;

    public MyPipeLine(){
        this.header = this.end = new HeadContext(new HeadHandler());
    }

    public void addFirst(PipeLineHandler handler) {
        PipeLineHandlerContext handlerContext = new PipeLineHandlerContext(handler);
        PipeLineHandlerContext tmp = header;
        header = handlerContext;
        header.setNext(tmp);
    }

    public void request(Object obj){
        if (header == null) {
            return;
        }
        header.doWork(obj);
    }

    final class HeadContext extends PipeLineHandlerContext {//这是一个内部类，为默认handler的context
        public HeadContext(PipeLineHandler handler) {
            super(handler);
        }
    }
    final class HeadHandler implements PipeLineHandler{//这是一个内部类，是pipeline的默认处理handler。

        @Override
        public void handler(PipeLineHandlerContext context, Object result) {
            System.out.println("end");
        }
    }


}
