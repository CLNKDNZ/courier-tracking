package com.migros.couriertracking.model.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COURIERENTRY")
public class CourierEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;
    @Column(name = "ENTRYDATETIME")
    private LocalDateTime entryDateTime;
    @Column(name = "LAT")
    private Double lat;
    @Column(name = "LON")
    private Double lon;
    @ManyToOne
    @JoinColumn(name = "COURIER_ID")
    private Courier courier;

}
