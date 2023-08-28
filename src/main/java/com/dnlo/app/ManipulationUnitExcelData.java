package com.dnlo.app;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ManipulationUnitExcelData {

    String code;
    String name;
    boolean returnable;
    boolean palette;
    boolean palettePriceList;
    String palettePlace;
    String length;
    String width;
    String height;
}