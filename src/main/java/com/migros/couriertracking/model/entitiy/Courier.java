package com.migros.couriertracking.model.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "COURIERID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

  /*  @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Courier_CourierEntry", joinColumns = {@JoinColumn(name = "ID")}, inverseJoinColumns = {@JoinColumn(name = "ID")})
    private List<CourierEntry> courierEntries;
*/
}
