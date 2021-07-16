package uz.pdp.appticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appticketservice.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
