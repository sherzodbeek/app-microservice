package uz.pdp.appbuyticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appbuyticket.entity.Payment;
import uz.pdp.appbuyticket.payload.ApiResponse;
import uz.pdp.appbuyticket.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public HttpEntity<?> addPayment(@RequestBody Payment payment) {
        ApiResponse response = paymentService.addPayment(payment);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }



    @PostMapping("/feign")
    public HttpEntity<?> addFeignPayment(@RequestBody Payment payment) {
        ApiResponse response = paymentService.addFeignPayment(payment);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
