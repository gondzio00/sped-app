package com.dnlo.app.infrastructure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A Projection for the {@link PackageEntity} entity
 */
public interface PackageData {
    String getTotalColli();

    String getPackageNumber();

    String getRoad();

    String getWeight();

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