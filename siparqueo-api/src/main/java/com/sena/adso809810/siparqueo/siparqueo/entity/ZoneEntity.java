package com.sena.adso809810.siparqueo.siparqueo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "zone")
public class ZoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "reference_type_id", nullable = false, updatable = true)
    private ReferenceTypeEntity type;

}
