package com.migros.couriertracking.model.dto.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Store Request Model DTO", description = "Store Request(DTO) Object")
public class StoreRequest {

    @ApiModelProperty(value = "Name Of Store Parameter", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(value = "Latitude Of Store Parameter", required = true)
    @NotNull
    private Double lat;

    @ApiModelProperty(value = "Longitude Of Store Parameter", required = true)
    @NotNull
    private Double lon;
}
