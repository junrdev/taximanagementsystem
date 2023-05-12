package com.junrdev.taxisys.models;
//taxi(s) owners

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "taxiowners", uniqueConstraints = {
        @UniqueConstraint(name = "unique_nationalid", columnNames = {"national_id"})
})
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Owner {


    @Id
    @SequenceGenerator(name = "owners_seq", sequenceName = "owners_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owners_seq")
    private Long id;


    private String firstName;

    private String lastName;

    private String nationality;

    private Long national_id;

    @Embedded
    private Adress adress;

}
