package com.migros.couriertracking.controller;


import com.migros.couriertracking.model.dto.request.CourierEntryRequest;
import com.migros.couriertracking.model.dto.response.CourierEntryResponse;
import com.migros.couriertracking.service.CourierTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("track")
@RequiredArgsConstructor
public class CourierTrackingController {

    private final CourierTrackingService courierTrackingService;

    @PostMapping("byLocation")
    public ResponseEntity<CourierEntryResponse> trackByLocation(@RequestBody CourierEntryRequest courierGeoLocationRequest) {
        var courierTrackingResponse = courierTrackingService.track(courierGeoLocationRequest);
        return new ResponseEntity(courierTrackingResponse, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CourierEntryRequest courierEntryRequest) {
        courierTrackingService.create(courierEntryRequest);
        return ResponseEntity.ok().build();
    }
}
