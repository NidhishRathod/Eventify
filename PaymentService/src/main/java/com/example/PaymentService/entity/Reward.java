package com.example.PaymentService.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rewards")
public class Reward {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(BigDecimal rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private BigDecimal rewardPoints;

    public Reward() {
        this.rewardPoints = BigDecimal.ZERO;
    }

}
