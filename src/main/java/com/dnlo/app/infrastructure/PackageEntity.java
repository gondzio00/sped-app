package com.dnlo.app.infrastructure;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class PackageEntity {

    @Id
    @Column(nullable = false)
    private String packageNumber;

    private String totalColli;
    private String road;
    private String weight;
//    private String manipUnit;

    Integer manipulationQuantity;

    @ManyToOne
    @JoinColumn(name = "manipulation_unit_code")
    ManipulationUnitEntity manipulationUnit;
//
//    @Embedded
//    private ManipulationData manipulationData;

    private String receiverName;
    private String receiverStreet;
    private String receiverCity;
    private String receiverPostalCode;

    private String senderName;
    private String senderStreet;
    private String senderCity;
    private String senderPostalCode;

    private String lastDepotStatus;
    private String lastStatus;
    private LocalDate lastStatusDate;

    private String receiverDepot;
    private String senderDepot;

    private LocalDateTime plannedCollectionDate;
    private LocalDateTime plannedDeliveryDate;

    private String collectionRoute;
    private String distributionRoute;

    private String collectionDriver;
    private String distributionDriver;

    private String volume;
    private String operaticVolumeWeight;
    private String operaticVolumeCalculated;
}
