package com.pd.api_redis_cache.service.model;

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
    private String items;
    private double total;
    private String userId;

}
