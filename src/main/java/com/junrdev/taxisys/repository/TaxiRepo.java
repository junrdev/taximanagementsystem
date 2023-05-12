package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepo extends JpaRepository<Taxi, Long> {
}
