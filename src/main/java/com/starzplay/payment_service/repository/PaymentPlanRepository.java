package com.starzplay.payment_service.repository;

import com.starzplay.payment_service.dto.PaymentPlanDto;
import com.starzplay.payment_service.model.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Long> {

    List<PaymentPlan> findAllByPaymentMethodId(long paymentMethodId);
}
