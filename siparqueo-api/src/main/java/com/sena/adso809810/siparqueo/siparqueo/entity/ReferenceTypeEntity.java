package com.sena.adso809810.siparqueo.siparqueo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "reference_type")
public class ReferenceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<ZoneEntity> zones;

}
