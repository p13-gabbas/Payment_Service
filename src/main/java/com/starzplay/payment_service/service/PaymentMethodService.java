package com.starzplay.payment_service.service;

import com.starzplay.payment_service.dto.PaymentMethodRequestDto;
import com.starzplay.payment_service.dto.PaymentMethodsResponseDto;
import com.starzplay.payment_service.dto.PaymentPlanRequestDto;

public interface PaymentMethodService {

    public void  savePaymentMethod(PaymentMethodRequestDto paymentMethodRequestDto);
    public void  savePaymentPlan(PaymentPlanRequestDto paymentPlanRequestDto);

    public PaymentMethodsResponseDto getAllPaymentMethods();

    public PaymentMethodsResponseDto getPaymentMethods(Long id, String name);
}
