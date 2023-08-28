package com.dnlo.app.infrastructure;

/**
 * A Projection for the {@link Palette} entity
 */
public interface PaletteInfo {
    boolean isPalette();

    boolean isPalettePriceList();

    String getPalettePlace();
}