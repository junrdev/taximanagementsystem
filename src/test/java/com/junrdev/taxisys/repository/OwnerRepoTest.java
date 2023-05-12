package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OwnerRepoTest {

    private final OwnerRepo repo;

    @Autowired
    public OwnerRepoTest(OwnerRepo repo) {
        this.repo = repo;
    }

    @Test
    void contextLoads(){}

    @Test
    void getOwners(){
        List<Owner> owners  = repo.findAll();

        System.out.println("owners = " + owners);
    }
}
