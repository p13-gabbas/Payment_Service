package com.starzplay.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.ws.soap.Addressing;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPlanDto {

    private long id;
    private double netAmount;
    private double taxAmount;
    private double grossAmount;
    private String currency;
    private String duration;
}
