package uz.pdp.appbuyticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appbuyticket.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
