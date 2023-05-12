package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Mileage;
import com.junrdev.taxisys.models.Taxi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaxiRepoTest {

    private final TaxiRepo taxiRepo;
    private final OwnerRepo ownerRepo;

    @Autowired
    public TaxiRepoTest(TaxiRepo taxiRepo, OwnerRepo ownerRepo) {
        this.taxiRepo = taxiRepo;
        this.ownerRepo = ownerRepo;
    }

    @Test
    void contextLoads(){}

    @Test
    void getTaxis(){
        List<Taxi> taxis = taxiRepo.findAll();

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

        Taxi saved = taxiRepo.save(taxi);

        System.out.println("saved taxi= " + saved);
    }

    @Test
    void addTaxiWithOwner(){
        Taxi taxi = Taxi.builder()
                .plateNumber("KCM 974T")
                .capacity(4)
                .fuelCapacity(4f)
                .loadedWeight(2489f)
                .weightUnloaded(1200f)
                .mileage(Mileage.builder().speed(120).mileagePer(Mileage.mileagePer.MPH).build())
                .owner(ownerRepo.findById(1l).get())//can choose to create a new one or find the existing one
                .build();

        Taxi saved = taxiRepo.save(taxi);

        System.out.println("saved taxi= " + saved);
    }

    @Test
    void updateTaxi(){
        Optional<Taxi> old_taxi = taxiRepo.findById(1L);

        if(old_taxi.isEmpty())
            throw new RuntimeException("Invalid id provided");

        Taxi taxi = old_taxi.get();

        taxi.setMaxWeight(3000f);

        System.out.println("taxiRepo.save(taxi) = " + taxiRepo.save(taxi));
    }

    @Test
    void deleteTaxi(){
        Optional<Taxi> taxi = taxiRepo.findById(1L);

        if(taxi.isEmpty())
            throw new RuntimeException("Invalid id provided");

        taxiRepo.delete(taxi.get());

        System.out.println("Deleted taxi");
    }

    @Test
    void findTaxiByOwnerId(){
        List<Taxi> taxis = taxiRepo.findByOwnerId(1l);

        System.out.println("taxis = " + taxis);
    }
}
