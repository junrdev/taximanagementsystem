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
@Table(name = "taxis", uniqueConstraints ={
        @UniqueConstraint(name = "unique_plate_number", columnNames = { "plateNumber"})
})
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

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private Owner owner;//represents the owner id

    private Boolean isAvailable;//if the taxi is available for assignment
}


