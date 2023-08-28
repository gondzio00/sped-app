package com.dnlo.app;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class ExcelReader {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    Map<Integer, BiConsumer<Object, ExcelData>> packagesMapping = new HashMap<>();
    Map<Integer, BiConsumer<Object, ManipulationUnitExcelData>> manipulationMapping = new HashMap<>();

    public void addSetters() {
        packagesMapping.put(0, (o, excelData) -> excelData.setTotalColli(String.valueOf(o)));
        packagesMapping.put(1, (o, excelData) -> excelData.setPackageNumber(String.valueOf(o)));
        packagesMapping.put(2, (o, excelData) -> excelData.setRoad(String.valueOf(o)));
        packagesMapping.put(3, (o, excelData) -> excelData.setWeight(String.valueOf(o)));
        packagesMapping.put(4, (o, excelData) -> excelData.setManipUnit(String.valueOf(o)));
        packagesMapping.put(5, (o, excelData) -> excelData.setReceiverName(String.valueOf(o)));
        packagesMapping.put(6, (o, excelData) -> excelData.setReceiverStreet(String.valueOf(o)));
        packagesMapping.put(7, (o, excelData) -> excelData.setReceiverCity(String.valueOf(o)));
        packagesMapping.put(8, (o, excelData) -> excelData.setReceiverPostalCode(String.valueOf(o)));
        packagesMapping.put(9, (o, excelData) -> excelData.setSenderName(String.valueOf(o)));
        packagesMapping.put(10, (o, excelData) -> excelData.setSenderStreet(String.valueOf(o)));
        packagesMapping.put(11, (o, excelData) -> excelData.setSenderCity(String.valueOf(o)));
        packagesMapping.put(12, (o, excelData) -> excelData.setSenderPostalCode(String.valueOf(o)));
        packagesMapping.put(13, (o, excelData) -> excelData.setLastDepotStatus(String.valueOf(o)));
        packagesMapping.put(14, (o, excelData) -> excelData.setLastStatus(String.valueOf(o)));
        packagesMapping.put(44, (o, excelData) -> excelData.setVolume(String.valueOf(o)));
        packagesMapping.put(45, (o, excelData) -> excelData.setOperaticVolumeWeight(String.valueOf(o)));
        packagesMapping.put(46, (o, excelData) -> excelData.setOperaticVolumeCalculated(String.valueOf(o)));
//        mapping.put(15, (o, excelData) -> excelData.setLastStatusDate(LocalDateTime.parse(String.valueOf(o), formatter)));

        manipulationMapping.put(0, (o, excelData) -> excelData.setCode(String.valueOf(o)));
        manipulationMapping.put(1, (o, excelData) -> excelData.setName(String.valueOf(o)));
        manipulationMapping.put(2, (o, excelData) -> excelData.setReturnable(mapToReturnable(String.valueOf(o))));
        manipulationMapping.put(3, (o, excelData) -> excelData.setPalette(fromString(String.valueOf(o))));
        manipulationMapping.put(4, (o, excelData) -> excelData.setPalettePriceList(fromString(String.valueOf(o))));
        manipulationMapping.put(5, (o, excelData) -> excelData.setPalettePlace(String.valueOf(o)));
        manipulationMapping.put(6, (o, excelData) -> excelData.setLength(String.valueOf(o)));
        manipulationMapping.put(7, (o, excelData) -> excelData.setWidth(String.valueOf(o)));
        manipulationMapping.put(8, (o, excelData) -> excelData.setHeight(String.valueOf(o)));
    }

    private boolean fromString(String value) {
        return switch (value.toUpperCase()) {
            case "TRUE" -> true;
            case "FALSE" -> false;
            default -> throw new IllegalArgumentException("Unknown type of boolean expression");
        };
    }

    private boolean mapToReturnable(String value) {
        return switch (value.toUpperCase()) {
            case "WYMIENNY" -> true;
            case "NIE" -> false;
            default -> throw new IllegalArgumentException("Unknown returnable type");
        };
    }

    public ExcelReader() {
        addSetters();
    }

    public List<ExcelData> readPackagesFile(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);

        List<ExcelData> excelDatas = new ArrayList<>();

        System.out.println("STARTING");

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;
            }

            ExcelData excelData = new ExcelData();

            for (Cell cell : row) {
                BiConsumer<Object, ExcelData> method = packagesMapping.get(cell.getColumnIndex());

                if (method != null) {
                    switch (cell.getCellType()) {
                        case STRING -> method.accept(cell.getStringCellValue(), excelData);
                        case NUMERIC -> method.accept(cell.getNumericCellValue(), excelData);
                        case BOOLEAN -> method.accept(cell.getBooleanCellValue(), excelData);
                    }
                }

            }

            excelDatas.add(excelData);
        }

        System.out.println("END");
        return excelDatas;
    }

    public List<ManipulationUnitExcelData> readManipulationFile(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);

        List<ManipulationUnitExcelData> excelDatas = new ArrayList<>();

        System.out.println("STARTING");

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;
            }

            ManipulationUnitExcelData excelData = new ManipulationUnitExcelData();

            for (Cell cell : row) {
                BiConsumer<Object, ManipulationUnitExcelData> method = manipulationMapping.get(cell.getColumnIndex());

                if (method != null) {
                    switch (cell.getCellType()) {
                        case STRING -> method.accept(cell.getStringCellValue(), excelData);
                        case NUMERIC -> method.accept(cell.getNumericCellValue(), excelData);
                        case BOOLEAN -> method.accept(cell.getBooleanCellValue(), excelData);
                    }
                }

            }

            excelDatas.add(excelData);
        }

        System.out.println("END");
        return excelDatas;
    }
}


