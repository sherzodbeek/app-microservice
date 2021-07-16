package uz.pdp.appticketservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appticketservice.entity.Ticket;
import uz.pdp.appticketservice.payload.ApiResponse;
import uz.pdp.appticketservice.payload.PaymentDto;
import uz.pdp.appticketservice.repository.TicketRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public String addTicket(Ticket ticket) {
        Ticket newTicket = new Ticket();
        newTicket.setFilmName(ticket.getFilmName());
        newTicket.setCode(UUID.randomUUID().toString());
        newTicket.setPrice(ticket.getPrice());
        ticketRepository.save(newTicket);
        return "Ticket added!";
    }

    public ApiResponse buyTicket(PaymentDto paymentDto) {
        Optional<Ticket> optional = ticketRepository.findById(paymentDto.getTicketId());
        if(optional.isEmpty())
            return new ApiResponse("Ticket not found!", false);
        Ticket ticket = optional.get();
        if(ticket.getPrice()!=paymentDto.getPrice())
            return new ApiResponse("Your funds are not enough!", false);
        ticket.setSold(true);
        ticketRepository.save(ticket);
        return new ApiResponse("Ticket sold!", true);
    }
}
