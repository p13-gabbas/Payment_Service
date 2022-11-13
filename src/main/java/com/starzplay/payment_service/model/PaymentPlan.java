package com.starzplay.payment_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "payment_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentPlan {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private double netAmount;
    private double taxAmount;
    private double grossAmount;
    private String currency;
    private String duration;
    @ManyToOne
    private PaymentMethod paymentMethod;
}
