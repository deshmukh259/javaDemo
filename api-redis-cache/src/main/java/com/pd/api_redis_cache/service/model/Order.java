package com.pd.api_redis_cache.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
@Builder

public class Order {

    @Id
    private Integer id;
    @Column
    private String items;
    @Column
    private double total;
    @Column
    private String userId;

}
