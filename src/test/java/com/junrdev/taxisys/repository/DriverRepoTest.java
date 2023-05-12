package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Adress;
import com.junrdev.taxisys.models.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DriverRepoTest {

    private final DriverRepository driverRepo;

    @Autowired
    public DriverRepoTest(DriverRepository driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Test
    void contextLoads(){}

    @Test
    void addDriver(){

        Driver driver = Driver.builder()
                .firstName("First")
                .lastName("Driver")
                .national_id(362813984L)
                .isAssigned(false)
                .adress(Adress.builder().location("Nairobi").zip_code(21L).box_number(01000L).build())
                .build();
        System.out.println("driver = " + driverRepo.save(driver));
    }

    @Test
    void getDrivers(){
        System.out.println("drivers = " + driverRepo.findAll());
    }
    
}
