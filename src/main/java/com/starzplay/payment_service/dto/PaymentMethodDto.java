package com.starzplay.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDto {

    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanDto> paymentPlanDtoList;

    public PaymentMethodDto(String name, String displayName, String paymentType){

    }
}
