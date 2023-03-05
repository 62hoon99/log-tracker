package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.helloTraceV2.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final TraceTemplate template;
    private final OrderServiceV5 orderService;

    // 생성자가 하나 있는 경우 Autowired 생략 가능
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.template = new TraceTemplate(trace);
        this.orderService = orderService;
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
