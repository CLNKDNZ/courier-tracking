package com.migros.couriertracking.repository;

import com.migros.couriertracking.model.entitiy.CourierEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface CourierEntryRepository extends JpaRepository<CourierEntry, Long> {


    @Query(value = "SELECT c.ENTRYDATETIME FROM COURIERENTRY c WHERE c.COURIER_ID =:courierId ORDER BY c.ENTRYDATETIME DESC  LIMIT 1",nativeQuery = true)
    Optional<LocalDateTime> getLastEntryDateTime(@Param("courierId") Long courierId);



}
