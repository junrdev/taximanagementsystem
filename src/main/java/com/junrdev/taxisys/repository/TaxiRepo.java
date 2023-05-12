package com.junrdev.taxisys.repository;

import com.junrdev.taxisys.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepo extends JpaRepository<Taxi, Long> {

    List<Taxi> findByOwnerId(Long owner_id);

//    @Query("SELECT t FROM taxis t WHERE t.owner.location = :location")
//    List<Taxi> findByOwnerAddressLocation(String location);

    @Query(value = "select * from taxis n where n.is_available =:availability", nativeQuery = true)
    List<Taxi> getTaxisByAvailability(Boolean availability);
}
