package com.skyline.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;
    private LocalDateTime payDateTime;
    private BigDecimal payAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user" )
    private User user;
}
