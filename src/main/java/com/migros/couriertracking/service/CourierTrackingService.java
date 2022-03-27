package com.migros.couriertracking.service;

import com.migros.couriertracking.exceptions.CourierRelationException;
import com.migros.couriertracking.exceptions.CourierTrackingRuleException;
import com.migros.couriertracking.model.dto.request.CourierEntryRequest;
import com.migros.couriertracking.model.dto.response.CourierEntryResponse;
import com.migros.couriertracking.model.entitiy.Store;
import com.migros.couriertracking.repository.CourierEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.migros.couriertracking.constants.Constant.*;
import static com.migros.couriertracking.util.Util.*;

@Service
@RequiredArgsConstructor
public class CourierTrackingService {

    private final CourierService courierService;
    private final StoreService storeService;
    private final CourierEntryRepository courierEntryRepository;

    public CourierEntryResponse track(CourierEntryRequest courierGeoLocationRequest) {
        var courierId = courierGeoLocationRequest.getCourier().getId();

        var isExistCourier = courierService.courierIsExist(courierId);
        var isInDistanceLimit = isInCourierDistancelimit(courierGeoLocationRequest);
        var isInEntryTimeLimit = isInEntryTimeLimit(courierGeoLocationRequest);


        if (isExistCourier && isInDistanceLimit && isInEntryTimeLimit) {
            var courierEntryEntity = courierEntryRequestToCourierEntryEntity(courierGeoLocationRequest);
            var savedCourierEntryEntity = courierEntryRepository.save(courierEntryEntity);
            return courierEntryEntityToCourierEntryResponse(savedCourierEntryEntity);

        } else {
            throw new CourierTrackingRuleException();
        }
    }

    public void create(CourierEntryRequest courierGeoLocationRequest) {
        var entity = courierEntryRequestToCourierEntryEntity(courierGeoLocationRequest);

        try {
            courierEntryRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new CourierRelationException();
        }

    }

    private boolean isInCourierDistancelimit(CourierEntryRequest courierGeoLocationRequest) {
        var result = false;
        var storeList = storeService.getStoreList();

        if (storeList.size() > 0) {
            for (Store store : storeList) {
                double distance = calculateDistance(courierGeoLocationRequest, store);
                if (distance <= DISTANCE_LIMIT) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private double calculateDistance(CourierEntryRequest courierGeoLocationRequest, Store store) {

        var courierLat = Math.toRadians(courierGeoLocationRequest.getLat());
        var courierLon = Math.toRadians(courierGeoLocationRequest.getLon());
        var storeLat = Math.toRadians(store.getLat());
        var storeLon = Math.toRadians(store.getLon());

        var dlon = storeLon - courierLon;
        var dlat = storeLat - courierLat;
        var a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(courierLat) * Math.cos(storeLat) * Math.pow(Math.sin(dlon / 2), 2);

        var c = 2 * Math.asin(Math.sqrt(a));
        return roundAvoid(c * RADIUS_OF_THE_WORLD * 1000, 4);
    }

    private boolean isInEntryTimeLimit(CourierEntryRequest courierGeoLocationRequest) {

        boolean result = false;

        var requestDatTime = courierGeoLocationRequest.getRequestTime();
        var lastEntryDatetime = courierEntryRepository.getLastEntryDateTime(courierGeoLocationRequest.getCourier().getId());

        if (lastEntryDatetime.isPresent()) {
            result = checkTimeRule(requestDatTime, lastEntryDatetime);

        } else {
            result = true;
        }

        return result;
    }

    private boolean checkTimeRule(LocalDateTime requestDatTime, Optional<LocalDateTime> lastEntryDatetime) {
        boolean result;
        var minusDateTime = requestDatTime.minusMinutes(1);

        if (minusDateTime.isAfter(lastEntryDatetime.get())) {
            result = true;

        } else {
            result = false;
        }
        return result;
    }


}
