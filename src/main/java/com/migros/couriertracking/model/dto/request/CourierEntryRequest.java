package com.migros.couriertracking.model.dto.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@ApiModel(value = "Courier Entry Request Model DTO", description = "Courier Entry Request(DTO) Object")
public class CourierEntryRequest {

    @ApiModelProperty(value = "Courier Object Of Courier Entry Parameter", required = true)
    @NotNull
    private CourierRequest courier;

    @ApiModelProperty(value = "Request Time Of Courier Entry Parameter", required = true)
    @NotNull
    private LocalDateTime requestTime;

    @ApiModelProperty(value = "Latitude Of Courier Entry Parameter", required = true)
    @NotNull
    private Double lat;

    @ApiModelProperty(value = "Longitude Object Of Courier Entry Parameter", required = true)
    @NotNull()
    private Double lon;

}
