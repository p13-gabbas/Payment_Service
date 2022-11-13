package com.starzplay.payment_service.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String displayName;
    private String paymentType;
}
