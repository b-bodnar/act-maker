package src.b.bodnar.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import src.b.bodnar.model.Apartment;
import src.b.bodnar.model.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static src.b.bodnar.util.NumberFormater.format;

public class ExcelReader {

    public static List<Person> excelReader(File file) {

        List<Person> persons = new ArrayList<>();
        try (FileInputStream excelFile = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getCell(0) == null) {
                    return persons;
                }
                Person person = createPerson(row);
                Apartment apartment = createApartment(row);
                person.setApartment(apartment);
                persons.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private static Apartment createApartment(Row row) {
        Apartment apartment = new Apartment();
        apartment.setSection(format(row.getCell(0).getNumericCellValue()));
        apartment.setFlor(format(row.getCell(1).getNumericCellValue()));
        apartment.setApartmentNumber(format(row.getCell(2).getNumericCellValue()));
        apartment.setCountRooms(format(row.getCell(3).getNumericCellValue()));
        apartment.setTotalArea(row.getCell(4).toString());
        apartment.setLivingArea(row.getCell(5).toString());
        return apartment;
    }

    private static Person createPerson(Row row) {
        Person person = new Person();
        person.setFullName(row.getCell(6).toString());
        person.setPassport(row.getCell(7).toString());
        person.setAddress(row.getCell(8).toString());
        person.setTaxID(format(row.getCell(9).getNumericCellValue()));
        return person;
    }
}
