package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTraceV2.LogTrace;

import java.util.function.Supplier;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, Supplier<T> supplier) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = supplier.get();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
