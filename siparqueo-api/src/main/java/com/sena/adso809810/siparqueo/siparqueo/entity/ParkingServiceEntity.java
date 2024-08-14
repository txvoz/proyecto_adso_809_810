package com.sena.adso809810.siparqueo.siparqueo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "parking_service")
public class ParkingServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "income_date")
    private Date incomeDate;

    @Column(name = "exit_date")
    private Date exitDate;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "income_user_id")
    private Long incomeUserId;

    @Column(name = "exit_user_id")
    private Long exitUserId;

}
