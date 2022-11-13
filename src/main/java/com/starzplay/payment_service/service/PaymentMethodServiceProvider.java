package com.starzplay.payment_service.service;

import com.starzplay.payment_service.dto.*;
import com.starzplay.payment_service.model.PaymentMethod;
import com.starzplay.payment_service.model.PaymentPlan;
import com.starzplay.payment_service.repository.PaymentMethodRepository;
import com.starzplay.payment_service.repository.PaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceProvider implements PaymentMethodService{

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    PaymentPlanRepository paymentPlanRepository;

    public void savePaymentMethod(PaymentMethodRequestDto paymentMethodRequestDto){
        paymentMethodRepository.save(PaymentMethod.builder()
                                .paymentType(paymentMethodRequestDto.getPaymentType())
                                .displayName(paymentMethodRequestDto.getDisplayName())
                                .name(paymentMethodRequestDto.getName()).build());

    }

    @Override
    public void savePaymentPlan(PaymentPlanRequestDto paymentPlanRequestDto) {
        if(paymentPlanRequestDto!=null) {
            Optional<PaymentMethod> optPaymentMethod = paymentMethodRepository.findById(paymentPlanRequestDto.getPaymentMethodId());
            if(optPaymentMethod.isPresent()) {
                paymentPlanRepository.save(PaymentPlan.builder()
                        .netAmount(paymentPlanRequestDto.getNetAmount())
                        .currency(paymentPlanRequestDto.getCurrency())
                        .duration(paymentPlanRequestDto.getDuration())
                        .taxAmount(paymentPlanRequestDto.getTaxAmount())
                        .grossAmount(paymentPlanRequestDto.getGrossAmount())
                        .paymentMethod(optPaymentMethod.get()).build());
            }
        }
    }

    public PaymentMethodsResponseDto getAllPaymentMethods(){
        List<PaymentPlan> paymentPlanList = null; List<PaymentMethodDto> response = new ArrayList<>();
        PaymentMethodsResponseDto paymentMethodsResponseDto = new PaymentMethodsResponseDto();
        PaymentMethodDto paymentMethodDto = null;List<PaymentPlanDto> paymentPlanDtoList = null;
        List<PaymentMethod> paymentMethodsList =paymentMethodRepository.findAll();
        if(paymentMethodsList!=null && paymentMethodsList.size()>0) {
            for (PaymentMethod paymentMethod : paymentMethodsList) {
                paymentMethodDto = new PaymentMethodDto();
                paymentMethodDto.setName(paymentMethod.getName());
                paymentMethodDto.setDisplayName(paymentMethod.getDisplayName());
                        paymentMethodDto.setPaymentType(paymentMethod.getPaymentType());
                paymentPlanList = paymentPlanRepository.findAllByPaymentMethodId(paymentMethod.getId());
                if (paymentPlanList != null && paymentPlanList.size() > 0) {
                    paymentPlanDtoList = new ArrayList<>();
                    for(PaymentPlan element : paymentPlanList) {
                        paymentPlanDtoList.add(new PaymentPlanDto(element.getId(), element.getNetAmount(),element.getTaxAmount(),
                                element.getGrossAmount(),element.getCurrency(), element.getDuration()));
                    }
                    paymentMethodDto.setPaymentPlanDtoList(paymentPlanDtoList);
                    response.add(paymentMethodDto);
                }else {
                    response.add(new PaymentMethodDto(
                            paymentMethod.getName(), paymentMethod.getDisplayName(),paymentMethod.getPaymentType(),null
                    ));
                }
            }
        }
        paymentMethodsResponseDto.setPaymentMethods(response);
        return paymentMethodsResponseDto;
    }

    @Override
    public PaymentMethodsResponseDto getPaymentMethods(Long id, String name) {
        PaymentMethodsResponseDto paymentMethodsResponseDto = new PaymentMethodsResponseDto();
        PaymentPlanDto paymentPlanDto = null; List<PaymentMethodDto> paymentMethodDtoList = new ArrayList<>();
        PaymentPlan paymentPlan = null; PaymentMethod paymentMethod = null;List<PaymentPlan> paymentPlanList = null;
        PaymentMethodDto paymentMethodDto = null;List<PaymentPlanDto> paymentPlanDtoList = new ArrayList<>();
        if(id!=null){
            Optional<PaymentPlan> optPaymentPlan = paymentPlanRepository.findById(id);
            if (optPaymentPlan.isPresent()){
                paymentPlan = optPaymentPlan.get();
                paymentMethodDto = new PaymentMethodDto();
                paymentMethodDto.setName(paymentPlan.getPaymentMethod().getName());
                paymentMethodDto.setDisplayName(paymentPlan.getPaymentMethod().getDisplayName());
                paymentMethodDto.setPaymentType(paymentPlan.getPaymentMethod().getPaymentType());
                paymentPlanDtoList.add(new PaymentPlanDto(paymentPlan.getId(), paymentPlan.getNetAmount(),paymentPlan.getTaxAmount(),
                                paymentPlan.getGrossAmount(),paymentPlan.getCurrency(), paymentPlan.getDuration()));
                paymentMethodDto.setPaymentPlanDtoList(paymentPlanDtoList);
                paymentMethodDtoList.add(paymentMethodDto);
            }
        }else if(name!=null && !name.isEmpty()){
            paymentMethod = paymentMethodRepository.findByNameEquals(name);
            if (paymentMethod!=null){
                paymentMethodDto = new PaymentMethodDto();
                paymentMethodDto.setName(paymentMethod.getName());
                paymentMethodDto.setDisplayName(paymentMethod.getDisplayName());
                paymentMethodDto.setPaymentType(paymentMethod.getPaymentType());

                paymentPlanList = paymentPlanRepository.findAllByPaymentMethodId(paymentMethod.getId());
                if(paymentPlanList!=null && paymentPlanList.size()>0) {
                    for (PaymentPlan element : paymentPlanList) {
                        paymentPlanDtoList.add(new PaymentPlanDto(element.getId(), element.getNetAmount(),element.getTaxAmount(),
                                element.getGrossAmount(),element.getCurrency(), element.getDuration()));

                    }
                    paymentMethodDto.setPaymentPlanDtoList(paymentPlanDtoList);
                    paymentMethodDtoList.add(paymentMethodDto);
                }
            }
        }
        paymentMethodsResponseDto.setPaymentMethods(paymentMethodDtoList);
        return paymentMethodsResponseDto;
    }
}
