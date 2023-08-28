package com.dnlo.app.infrastructure;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Palette {

    private boolean palette;
    private boolean palettePriceList;
    private String palettePlace;
}
