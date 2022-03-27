package com.migros.couriertracking.service;

import com.migros.couriertracking.model.dto.request.CourierRequest;
import com.migros.couriertracking.model.dto.response.CourierResponse;
import com.migros.couriertracking.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.migros.couriertracking.util.Util.courierEntityToCourierResponse;
import static com.migros.couriertracking.util.Util.courierRequestToCourierEntity;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierResponse create(CourierRequest courierRequest) {
        var courier = courierRequestToCourierEntity(courierRequest);
        var savedCourierEntity = courierRepository.save(courier);
        return courierEntityToCourierResponse(savedCourierEntity);
    }


    public void delete(CourierRequest courierRequest) {
        var courier = courierRequestToCourierEntity(courierRequest);
        courierRepository.delete(courier);

    }

    public boolean courierIsExist(Long courierId) {
        return courierRepository.existsById(courierId);
    }
}
