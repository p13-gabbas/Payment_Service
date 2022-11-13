package com.starzplay.payment_service.repository;

import com.starzplay.payment_service.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    PaymentMethod findByNameEquals(String namexs);
}
