package uz.pdp.appbuyticket.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.appbuyticket.entity.Payment;
import uz.pdp.appbuyticket.payload.ApiResponse;

@FeignClient(name = "ticket-service")
public interface TicketProxy {
    @PostMapping("/api/tickets/buy")
    ApiResponse buyTicket(@RequestBody Payment payment);
}
