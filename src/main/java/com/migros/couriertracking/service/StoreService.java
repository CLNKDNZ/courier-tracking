package com.migros.couriertracking.service;


import com.migros.couriertracking.model.dto.request.StoreRequest;
import com.migros.couriertracking.model.dto.response.StoreResponse;
import com.migros.couriertracking.model.entitiy.Store;
import com.migros.couriertracking.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.migros.couriertracking.util.Util.storeRequestToStoreEntity;
import static com.migros.couriertracking.util.Util.storeEntityToStoreResponse;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreResponse create(StoreRequest storeRequest) {

        var store = storeRequestToStoreEntity(storeRequest);
        var savedStore = storeRepository.save(store);
        return storeEntityToStoreResponse(store);
    }

    public List<Store> getStoreList() {

        return storeRepository.findAll();
    }

}
