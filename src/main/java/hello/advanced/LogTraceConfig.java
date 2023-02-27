package hello.advanced;

import hello.advanced.trace.helloTraceV2.FieldLogTrace;
import hello.advanced.trace.helloTraceV2.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
