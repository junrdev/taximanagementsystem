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
@Table(name = "taxi_drivers", uniqueConstraints = {
        @UniqueConstraint(name = "unique_driver_national_id", columnNames = "national_id")
})
public class Driver {

    @SequenceGenerator(name = "taxidrivers_seq", allocationSize = 1, sequenceName = "taxidrivers_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxidrivers_seq")
    private Long Id;

    private String firstName;

    private String lastName;

    private String nationality;

    private Long national_id;

    private Boolean isAssigned;

    @Embedded
    private Adress adress;

    //info needed -> registered under which owner -> what car assigned
}
