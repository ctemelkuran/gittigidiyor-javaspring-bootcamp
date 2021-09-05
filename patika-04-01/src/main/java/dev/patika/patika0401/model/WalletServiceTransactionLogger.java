package dev.patika.patika0401.model;

import dev.patika.patika0401.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WalletServiceTransactionLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private double balanceBefore; // Hassas bilgilerin başı ve sonu loglanır
    private double balanceAfter; // Hassas bilgilerin başı ve sonu loglanır
    private double transactionAmount; // Hassas bilgilerin başı ve sonu loglanır
    @Enumerated(EnumType.STRING)
    private Currency transactionCurrency;
    private LocalDateTime transactionDateTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    private String transactionType;

}
