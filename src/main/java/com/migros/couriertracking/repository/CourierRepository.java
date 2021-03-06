package com.migros.couriertracking.repository;

import com.migros.couriertracking.model.entitiy.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {


}