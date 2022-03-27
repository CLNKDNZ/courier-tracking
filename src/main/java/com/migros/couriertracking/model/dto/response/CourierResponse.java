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
public class CourierResponse {

    private Long id;
    private String name;
    private String surname;
    private LocalDateTime createdAt;
}
