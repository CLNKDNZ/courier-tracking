package com.migros.couriertracking.controller;

import com.migros.couriertracking.constants.Constant;
import com.migros.couriertracking.model.dto.request.CourierRequest;
import com.migros.couriertracking.model.dto.response.CourierResponse;
import com.migros.couriertracking.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    public ResponseEntity<CourierResponse> create(@RequestBody CourierRequest courierRequest) {
        var courier = courierService.create(courierRequest);
        return new ResponseEntity(courier, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody CourierRequest courierRequest) {
        courierService.delete(courierRequest);
        return ResponseEntity.ok().body(Constant.SUCCESSFULLY_DELETED);
    }
}
