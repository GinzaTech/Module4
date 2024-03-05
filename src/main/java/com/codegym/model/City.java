package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Nation nation;
    private double acreage;
    private String population;
    private double gdp;
    private String description;


}
