package com.dnlo.app;

import com.dnlo.app.infrastructure.ManipulationUnitEntity;
import com.dnlo.app.infrastructure.Palette;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExcelManipulationDataMapper {

    List<ManipulationUnitEntity> toManipulationDataEntities(List<ManipulationUnitExcelData> excelDataList);

    @Mapping(target = "palette", expression = "java(resolvePalette(excelData))")
    ManipulationUnitEntity toManipulationDataEntity(ManipulationUnitExcelData excelData);

    default Palette resolvePalette(ManipulationUnitExcelData excelData) {
        return Palette.builder()
                .palette(excelData.isPalette())
                .palettePriceList(excelData.isPalettePriceList())
                .palettePlace(excelData.getPalettePlace())
                .build();
    }
}