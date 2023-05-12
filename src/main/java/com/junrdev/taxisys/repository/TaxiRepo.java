package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepo extends JpaRepository<Taxi, Long> {

    List<Taxi> findByOwnerId(Long owner_id);
}
