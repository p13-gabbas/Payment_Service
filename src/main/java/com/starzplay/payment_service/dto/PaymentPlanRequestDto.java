package com.starzplay.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlanRequestDto {

    private double netAmount;
    private double taxAmount;
    private double grossAmount;
    private String currency;
    private String duration;
    private long paymentMethodId;
}
