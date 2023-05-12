package com.junrdev.taxisys.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "taxis")
public class Taxi {

    @SequenceGenerator(name = "taxi_seq", allocationSize = 1, sequenceName = "taxi_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxi_seq")
    private Long Id;

    private String plateNumber;

    private int capacity;

    private float fuelCapacity;

    @Embedded
    private Mileage mileage;

    private float weightUnloaded;

    private float loadedWeight;

    private float maxWeight;
}


