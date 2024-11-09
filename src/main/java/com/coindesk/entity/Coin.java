package com.coindesk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "coin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String symbol;

    @Column
    private String rate;

    @Column
    private String description;

    @Column(name = "rate_float")
    private BigDecimal rateFloat;

    @Column(name = "update_time")
    private Date updateTime;


}
