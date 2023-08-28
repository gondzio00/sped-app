package com.dnlo.app;

import com.dnlo.app.infrastructure.PackageUpdatedEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackageUpdateMapper {

    PackageUpdatedEntity toPackageUpdatedEntity(PackageUpdate update);

}