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
@Table(name = "assignments")
public class Assignment {

    @Id
    @SequenceGenerator(
            name = "assignments_seq",
            sequenceName = "assignments_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignments_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "taxi", referencedColumnName = "Id")
    private Taxi taxi;

    @OneToOne
    @JoinColumn(name = "driver", referencedColumnName = "Id")
    private Driver driver;

    @Enumerated(value = EnumType.STRING)
    private AssignmentStatus status;

}
