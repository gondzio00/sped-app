package com.dnlo.app.infrastructure;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A Projection for the {@link PackageUpdatedEntity} entity
 */
public interface PackageUpdatedData {
    String getPackageNumber();

    String getTotalColli();

    String getRoad();

    String getWeight();

    Integer getManipulationQuantity();

    String getManipulationUnit();

    String getReceiverName();

    String getReceiverStreet();

    String getReceiverCity();

    String getReceiverPostalCode();

    String getSenderName();

    String getSenderStreet();

    String getSenderCity();

    String getSenderPostalCode();

    String getLastDepotStatus();

    String getLastStatus();

    LocalDate getLastStatusDate();

    String getReceiverDepot();

    String getSenderDepot();

    LocalDateTime getPlannedCollectionDate();

    LocalDateTime getPlannedDeliveryDate();

    String getCollectionRoute();

    String getDistributionRoute();

    String getCollectionDriver();

    String getDistributionDriver();

    String getVolume();

    String getOperaticVolumeWeight();

    String getOperaticVolumeCalculated();
}