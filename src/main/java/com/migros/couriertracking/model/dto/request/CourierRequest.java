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

@ApiModel(value = "Courier Request Model DTO", description = "Courier Request(DTO) Object")
public class CourierRequest {

    @ApiModelProperty(value = "Id Of Courier Parameter", required = true)
    @NotNull
    private Long id;

    @ApiModelProperty(value = "Name Of Courier Parameter", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(value = "Surname Of Courier Parameter", required = true)
    @NotNull
    private String surname;
}
