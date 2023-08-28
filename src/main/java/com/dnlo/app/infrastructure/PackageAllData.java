package com.dnlo.app.infrastructure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A Projection for the {@link PackageEntity} entity
 */
public interface PackageAllData {
    String getTotalColli();

    String getPackageNumber();

    String getRoad();

    String getWeight();

    Integer getManipulationQuantity();

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

    ManipulationUnitEntityInfo getManipulationUnit();

    /**
     * A Projection for the {@link ManipulationUnitEntity} entity
     */
    interface ManipulationUnitEntityInfo {
        String getCode();

        String getName();

        boolean isReturnable();

        String getLength();

        String getWidth();

        String getHeight();

        PaletteInfo1 getPalette();

        /**
         * A Projection for the {@link Palette} entity
         */
        interface PaletteInfo1 {
            boolean isPalette();

            boolean isPalettePriceList();

            String getPalettePlace();
        }
    }
}