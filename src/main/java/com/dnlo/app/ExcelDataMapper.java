package com.dnlo.app;

import com.dnlo.app.infrastructure.ManipulationData;
import com.dnlo.app.infrastructure.ManipulationUnitEntity;
import com.dnlo.app.infrastructure.PackageEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExcelDataMapper {

    List<PackageEntity> toPackagesEntities(List<ExcelData> excelDataList);

    PackageEntity toPackageEntity(ExcelData excelData);

    @AfterMapping
    default void afterPackageToEntityMapping(ExcelData excelData, @MappingTarget PackageEntity entity) {
        ManipulationData manipulationData = ManipulationData.from(excelData.getManipUnit());

        if (manipulationData != null) {
            entity.setManipulationUnit(new ManipulationUnitEntity(manipulationData.getManipulationUnit().getCode()));
            entity.setManipulationQuantity(manipulationData.getQuantity());
        }

    }
}