package pipeline;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuzhihan on 2017/11/24.
 */
public class PipeLineHandlerContext {
    private ExecutorService executorService = new ThreadPoolExecutor(0,4,
                                      60L,TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    private PipeLineHandler handler;
    private PipeLineHandlerContext next;


    public PipeLineHandlerContext(PipeLineHandler handler) {
        this.handler = handler;
    }

    public void setNext(PipeLineHandlerContext nextHandlerContext) {
        this.next = nextHandlerContext;
    }

    public void doWork(final Object result){
        PipeLineHandlerContext context = this;
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                handler.handler(context, result);
            }
        });
    }

    public void write(Object result){
        next.doWork(result);
    }
}
