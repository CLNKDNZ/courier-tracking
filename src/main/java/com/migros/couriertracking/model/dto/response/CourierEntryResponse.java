package com.migros.couriertracking.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourierEntryResponse {

    private CourierResponse courier;
    private LocalDateTime createdAt;
    private Double lat;
    private Double lon;
}
