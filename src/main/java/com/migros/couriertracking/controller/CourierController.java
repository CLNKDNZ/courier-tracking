package com.migros.couriertracking.controller;

import com.migros.couriertracking.constants.Constant;
import com.migros.couriertracking.model.dto.request.CourierRequest;
import com.migros.couriertracking.model.dto.response.CourierResponse;
import com.migros.couriertracking.service.CourierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courier")
@RequiredArgsConstructor
@Api(value = "Courier Api Documentation")
public class CourierController {

    private final CourierService courierService;

    @PostMapping
    @ApiOperation(value = "Add New Courier")
    public ResponseEntity<CourierResponse> create(@RequestBody CourierRequest courierRequest) {
        var courier = courierService.create(courierRequest);
        return new ResponseEntity(courier, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete Courier By Id")
    public ResponseEntity delete(@RequestBody CourierRequest courierRequest) {
        courierService.delete(courierRequest);
        return ResponseEntity.ok().body(Constant.SUCCESSFULLY_DELETED);
    }
}
