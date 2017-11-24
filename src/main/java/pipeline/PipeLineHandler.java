package pipeline;

/**
 * Created by liuzhihan on 2017/11/24.
 */
public interface PipeLineHandler {
    void handler(PipeLineHandlerContext context, Object result);
}
