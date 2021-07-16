package uz.pdp.appticketservice.payload;

import lombok.Data;

@Data
public class PaymentDto {
    private Integer ticketId;

    private double price;
}
