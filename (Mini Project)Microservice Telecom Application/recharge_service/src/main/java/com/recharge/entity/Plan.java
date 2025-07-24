package com.recharge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer validity;
}


