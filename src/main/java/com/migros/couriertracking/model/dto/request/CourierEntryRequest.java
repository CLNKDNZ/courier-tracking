package com.migros.couriertracking.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourierEntryRequest {
    private CourierRequest courier;
    private LocalDateTime requestTime;
    private Double lat;
    private Double lon;

}
