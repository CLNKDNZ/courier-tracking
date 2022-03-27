package com.migros.couriertracking;

import com.migros.couriertracking.controller.CourierController;
import com.migros.couriertracking.model.entitiy.Courier;
import com.migros.couriertracking.model.entitiy.Store;
import com.migros.couriertracking.repository.CourierRepository;
import com.migros.couriertracking.repository.StoreRepository;
import com.migros.couriertracking.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
@RequiredArgsConstructor
public class CourierTrackingApplication implements CommandLineRunner {

    private final StoreRepository storeRepository;
    private final CourierRepository courierRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourierTrackingApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        DataInıtialize();
    }


    public void DataInıtialize() {

        InitializeStoreData();
        InitializeCourierData();

    }

    private void InitializeStoreData() {
        List<Store> storeList = new ArrayList<>();

        var store1 = Store.builder()
                .name("Ataşehir MMM Migros")
                .lat(40.9923307)
                .lon(29.1244229).build();
        storeList.add(store1);
        var store2 = Store.builder()
                .name("Novada MMM Migros")
                .lat(40.986106)
                .lon(29.1161293).build();
        storeList.add(store2);
        var store3 = Store.builder()
                .name("Beylikdüzü 5M Migros")
                .lat(41.0066851)
                .lon(28.6552262).build();
        storeList.add(store3);
        var store4 = Store.builder()
                .name("Ortaköy MMM Migros")
                .lat(41.055783)
                .lon(29.0210292).build();
        storeList.add(store4);
        var store5 = Store.builder()
                .name("Caddebostan MMM Migros")
                .lat(40.9632463)
                .lon(29.0630908).build();
        storeList.add(store5);
        storeRepository.saveAll(storeList);
    }

    private void InitializeCourierData() {
        List<Courier> courierList = new ArrayList<>();
        var courier1 = Courier.builder().name("Deniz").surname("Celenk").build();
        courierList.add(courier1);
        var courier2 = Courier.builder().name("Ahmet").surname("Toplu").build();
        courierList.add(courier2);
        var courier3 = Courier.builder().name("Ayse").surname("Bulut").build();
        courierList.add(courier3);
        var courier4 = Courier.builder().name("Kemal").surname("Kemal").build();
        courierList.add(courier4);
        var courier5 = Courier.builder().name("Ali").surname("Solgun").build();
        courierList.add(courier5);

        courierRepository.saveAll(courierList);
    }
}
