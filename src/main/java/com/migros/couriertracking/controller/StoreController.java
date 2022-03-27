package com.migros.couriertracking.controller;


import com.migros.couriertracking.exceptions.StoreCreateException;
import com.migros.couriertracking.model.dto.request.StoreRequest;
import com.migros.couriertracking.model.dto.response.StoreResponse;
import com.migros.couriertracking.model.entitiy.Store;
import com.migros.couriertracking.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("store")
@RequiredArgsConstructor
@Api(value = "Store Api Documentation")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    @ApiOperation(value = "Create New Store")
    public ResponseEntity<StoreResponse> create(@RequestBody StoreRequest storeRequest) {
        var savedStore = storeService.create(storeRequest);
        if (savedStore == null) {
            throw new StoreCreateException();
        }
        return new ResponseEntity(savedStore, HttpStatus.CREATED);
    }
}
