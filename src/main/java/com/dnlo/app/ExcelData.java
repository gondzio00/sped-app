package com.dnlo.app;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ExcelData {

    String totalColli;
    String packageNumber;
    String road;
    String weight;
    String manipUnit;

    String receiverName;
    String receiverStreet;
    String receiverCity;
    String receiverPostalCode;

    String senderName;
    String senderStreet;
    String senderCity;
    String senderPostalCode;

    String lastDepotStatus;
    String lastStatus;
    LocalDateTime lastStatusDate;

    String receiverDepot;
    String senderDepot;

    LocalDateTime plannedCollectionDate;
    LocalDateTime plannedDeliveryDate;

    String collectionRoute;
    String distributionRoute;

    String collectionDriver;
    String distributionDriver;

    String volume;
    String operaticVolumeWeight;
    String operaticVolumeCalculated;
}
