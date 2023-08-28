package com.dnlo.app.infrastructure;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ManipulationUnitEntity {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    private String name;
    private boolean returnable;

    @Embedded
    private Palette palette;

    private String length;
    private String width;
    private String height;

    @OneToMany(mappedBy = "manipulationUnit", orphanRemoval = true)
    private List<PackageEntity> packages = new ArrayList<>();

    public ManipulationUnitEntity(String code) {
        this.code = code;
    }

    public static ManipulationUnitEntity from(String code) {
        return ManipulationUnitEntity.builder()
                .code(code)
                .build();
    }
}
