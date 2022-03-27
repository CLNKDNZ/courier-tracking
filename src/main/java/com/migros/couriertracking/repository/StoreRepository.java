package com.migros.couriertracking.repository;

import com.migros.couriertracking.model.entitiy.Courier;
import com.migros.couriertracking.model.entitiy.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {


}