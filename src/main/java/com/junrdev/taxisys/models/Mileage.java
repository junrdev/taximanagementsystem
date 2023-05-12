package com.junrdev.taxisys.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mileage {
    private int speed;

    @Enumerated(value = EnumType.STRING)
    private mileagePer mileagePer;

    public enum mileagePer {
        KMH, MPH;
    }
}
