package com.taidt9.OrderService.model;


import com.taidt9.OrderService.enumeration.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private long productId;
    private long amount;
    private long quantity;
    private PaymentMode paymentMode;

}
