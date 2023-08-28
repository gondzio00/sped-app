package com.dnlo.app;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PackageUpdate {

    private String packageNumber;
    private String totalColli;
    private String road;
    private String weight;

    Integer manipulationQuantity;
    String manipulationUnitCode;

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