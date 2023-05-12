package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Assignment;
import com.junrdev.taxisys.models.AssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {

    List<Assignment> findAssignmentsByStatus(AssignmentStatus status);
    Assignment findAssignmentByDriverId(Long driver_id);
    Assignment findAssignmentByTaxiId(Long taxi_id);
}
