package src.b.bodnar;

import src.b.bodnar.model.Person;
import src.b.bodnar.service.ExcelReader;
import src.b.bodnar.service.WordWriter;

import java.io.File;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        File src = new File("C:/Users/b.bodnar/Desktop/Acts.xlsx");
        File template = new File("C:/Users/b.bodnar/Desktop/Acts.xlsx");

        List<Person> people =  ExcelReader.excelReader(src);
        WordWriter wordWriter = new WordWriter();
        wordWriter.createDoc("C:/Users/b.bodnar/Desktop/template.docx", people);
    }
}
