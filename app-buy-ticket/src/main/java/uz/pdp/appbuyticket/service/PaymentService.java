package uz.pdp.appbuyticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.appbuyticket.entity.Payment;
import uz.pdp.appbuyticket.feign.TicketProxy;
import uz.pdp.appbuyticket.payload.ApiResponse;
import uz.pdp.appbuyticket.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final RestTemplate template;
    private final TicketProxy proxy;

    @Autowired
    public PaymentService(PaymentRepository repository, RestTemplate template, TicketProxy proxy) {
        this.repository = repository;
        this.template = template;
        this.proxy = proxy;
    }

    public ApiResponse addPayment(Payment payment) {
        ApiResponse apiResponse = template.postForObject("http://localhost:8080/api/tickets/buy", payment, ApiResponse.class);
        if(apiResponse!= null && !apiResponse.isSuccess())
            return apiResponse;
        Payment newPayment = new Payment();
        newPayment.setPrice(payment.getPrice());
        newPayment.setTicketId(payment.getTicketId());
        repository.save(newPayment);
        return new ApiResponse("Ticket sold!", true);
    }



    public ApiResponse addFeignPayment(Payment payment) {
        ApiResponse apiResponse = proxy.buyTicket(payment);
        if(apiResponse!= null && !apiResponse.isSuccess())
            return apiResponse;
        Payment newPayment = new Payment();
        newPayment.setPrice(payment.getPrice());
        newPayment.setTicketId(payment.getTicketId());
        repository.save(newPayment);
        return new ApiResponse("Ticket sold!", true);
    }
}
