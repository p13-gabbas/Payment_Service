package com.starzplay.payment_service.controller;

import com.starzplay.payment_service.dto.PaymentMethodRequestDto;
import com.starzplay.payment_service.dto.PaymentMethodsResponseDto;
import com.starzplay.payment_service.dto.PaymentPlanRequestDto;
import com.starzplay.payment_service.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1.0/congiguration/")
public class ResourceRestController {

    @Autowired
    PaymentMethodService paymentMethodService;
    @PostMapping("/payment-methods")
    public ResponseEntity savePaymentMethod(@RequestBody PaymentMethodRequestDto paymentMethodRequestDto){
        paymentMethodService.savePaymentMethod(paymentMethodRequestDto);
        return null;
    }

    @PostMapping("/payment-plans")
    public ResponseEntity savePaymentPlans(@RequestBody PaymentPlanRequestDto paymentPlanRequestDto){
        paymentMethodService.savePaymentPlan(paymentPlanRequestDto);
        return null;
    }


    @GetMapping("/all/payment-methods")
    public PaymentMethodsResponseDto getAllPaymentMethod(){

        return paymentMethodService.getAllPaymentMethods();
    }

    //it will have a request param of id
    @GetMapping("payment-methods")
    public PaymentMethodsResponseDto getPaymentMethod(@RequestParam(name = "id", required = false) Long id,
                                                      @RequestParam(name = "name", required = false) String name){

        return paymentMethodService.getPaymentMethods( id, name);
    }

    @PutMapping("payment-methods")
    public ResponseEntity updatePaymentMethod(){

        return null;
    }
}
