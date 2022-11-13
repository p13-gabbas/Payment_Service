package com.starzplay.payment_service.dto;

import com.starzplay.payment_service.model.PaymentPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodRequestDto {

    private String name;
    private String displayName;
    private String paymentType;
    private PaymentPlan paymentPlans;
}
