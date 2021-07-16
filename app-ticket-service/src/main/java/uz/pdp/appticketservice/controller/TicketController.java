package uz.pdp.appticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appticketservice.entity.Ticket;
import uz.pdp.appticketservice.payload.ApiResponse;
import uz.pdp.appticketservice.payload.PaymentDto;
import uz.pdp.appticketservice.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @PostMapping
    public HttpEntity<?> addTicket(@RequestBody Ticket ticket) {
        String soldTicket = ticketService.addTicket(ticket);
        return ResponseEntity.ok(soldTicket);
    }

    @PostMapping("/buy")
    public ApiResponse buyTicket(@RequestBody PaymentDto paymentDto) {
        ApiResponse apiResponse = ticketService.buyTicket(paymentDto);
        return apiResponse;
    }
}
