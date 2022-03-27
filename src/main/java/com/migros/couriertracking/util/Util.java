package com.migros.couriertracking.util;

import com.migros.couriertracking.model.dto.request.CourierEntryRequest;
import com.migros.couriertracking.model.dto.request.CourierRequest;
import com.migros.couriertracking.model.dto.request.StoreRequest;
import com.migros.couriertracking.model.dto.response.CourierEntryResponse;
import com.migros.couriertracking.model.dto.response.CourierResponse;
import com.migros.couriertracking.model.dto.response.StoreResponse;
import com.migros.couriertracking.model.entitiy.Courier;
import com.migros.couriertracking.model.entitiy.CourierEntry;
import com.migros.couriertracking.model.entitiy.Store;

import java.time.LocalDateTime;

public class Util {

    public static Store storeRequestToStoreEntity(StoreRequest storeRequest) {
        return Store.builder().name(storeRequest.getName()).lat(storeRequest.getLat()).lon(storeRequest.getLon()).build();
    }

    public static StoreResponse storeEntityToStoreResponse(Store store) {
        return StoreResponse.builder().name(store.getName()).lat(store.getLat()).lon(store.getLon()).build();
    }

    public static Courier courierRequestToCourierEntity(CourierRequest courierRequest) {
        return Courier.builder().name(courierRequest.getName()).surname(courierRequest.getSurname()).id(courierRequest.getId()).build();
    }

    public static CourierResponse courierEntityToCourierResponse(Courier courier) {
        return CourierResponse.builder().name(courier.getName()).surname(courier.getSurname()).createdAt(LocalDateTime.now()).id(courier.getId()).build();
    }

    public static CourierEntry courierEntryRequestToCourierEntryEntity(CourierEntryRequest courierGeoLocationRequest) {
        var courierEntity = courierRequestToCourierEntity(courierGeoLocationRequest.getCourier());
        return CourierEntry.builder().lat(courierGeoLocationRequest.getLat()).lon(courierGeoLocationRequest.getLon()).entryDateTime(courierGeoLocationRequest.getRequestTime()).courier(courierEntity).build();
    }

    public static CourierEntryResponse courierEntryEntityToCourierEntryResponse(CourierEntry courierEntry) {
        var courierResponse = courierEntityToCourierResponse(courierEntry.getCourier());
        return CourierEntryResponse.builder().lat(courierEntry.getLat()).lon(courierEntry.getLon()).createdAt(courierEntry.getEntryDateTime()).courier(courierResponse).build();
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }


}
