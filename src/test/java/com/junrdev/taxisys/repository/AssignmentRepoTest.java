package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Assignment;
import com.junrdev.taxisys.models.AssignmentStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AssignmentRepoTest {

    private final AssignmentRepo assignmentRepo;
    private final TaxiRepo taxiRepo;
    private final DriverRepository driverRepo;

    @Autowired
    public AssignmentRepoTest(AssignmentRepo assignmentRepo, TaxiRepo taxiRepo, DriverRepository driverRepo) {
        this.assignmentRepo = assignmentRepo;
        this.taxiRepo = taxiRepo;
        this.driverRepo = driverRepo;
    }

    @Test
    void contextLoads(){}

    @Test
    void addAssignment(){

        Assignment assignment = Assignment.builder()
                .driver(driverRepo.findById(1l).get())
                .taxi(taxiRepo.findById(5l).get())
                .status(AssignmentStatus.INPROGRESS)
                .build();

        System.out.println("assignment = " + assignmentRepo.save(assignment));

    }

    @Test
    void getAllAssignments(){
        List<Assignment> assignments = assignmentRepo.findAll();

        System.out.println("assignments = " + assignments);
    }

    @Test
    void updateAssignmentStatus(){
        Optional<Assignment> optionalAssignment = assignmentRepo.findById(1l);

        if (optionalAssignment.isEmpty())
            throw new RuntimeException("Invalid assignment id");

        Assignment assignment = optionalAssignment.get();

        assignment.setStatus(AssignmentStatus.FINISHED);

        assignmentRepo.save(assignment);

        System.out.println("Assignment status updated successfully");
    }

    @Test
    void getAssignmentsByStatus(){

        List<Assignment> assignments= assignmentRepo.findAssignmentsByStatus(AssignmentStatus.INPROGRESS);

        System.out.println("assignments = " + assignments);
    }

    @Test
    void getAssignmentsByDriver(){

        Assignment assignments= assignmentRepo.findAssignmentByDriverId(1l);

        System.out.println("assignments = " + assignments);
    }

    @Test
    void getAssignmentsByTaxi(){

        Assignment assignments= assignmentRepo.findAssignmentByTaxiId(1l);

        System.out.println("assignments = " + assignments);
    }
}
