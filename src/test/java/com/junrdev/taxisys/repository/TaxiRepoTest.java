package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Mileage;
import com.junrdev.taxisys.models.Taxi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaxiRepoTest {

    private final TaxiRepo repo;

    @Autowired
    public TaxiRepoTest(TaxiRepo repo) {
        this.repo = repo;
    }

    @Test
    void contextLoads(){}

    @Test
    void getTaxis(){
        List<Taxi> taxis = repo.findAll();

        System.out.println("taxis = " + taxis);
    }

    @Test
    void addTaxi(){
        Taxi taxi = Taxi.builder()
                .plateNumber("KCM 973T")
                .capacity(4)
                .fuelCapacity(4f)
                .loadedWeight(2489f)
                .weightUnloaded(1200f)
                .mileage(Mileage.builder().speed(120).mileagePer(Mileage.mileagePer.MPH).build())
                .build();

        Taxi saved = repo.save(taxi);

        System.out.println("saved taxi= " + saved);
    }
}
