package com.dnlo.app.infrastructure;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManipulationData {
    Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    ManipulationUnitEntity manipulationUnit;

    public static ManipulationData from(String stringValue) {
        Pattern pattern = Pattern.compile("([0-9]+)([A-Za-z]+)");
        Matcher matcher = pattern.matcher(stringValue);

        if (matcher.find()) {
            int value = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);

            return new ManipulationData(value, ManipulationUnitEntity.from(unit));
        }

        return null;
    }
}
