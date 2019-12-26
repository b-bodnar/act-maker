package src.b.bodnar.execute;

import src.b.bodnar.model.Person;
import src.b.bodnar.service.ExcelReader;
import src.b.bodnar.service.WordWriter;

import java.io.File;
import java.util.List;

public class Executor {

    private static final String PATH_TO_DIRECTORY = "C:/Users/b.bodnar/Desktop/work/Act_Maker/files/";
    private static final String PATH_TO_TEMPLATE = "C:/Users/b.bodnar/Desktop/template.docx";

    public static void execute(String srcFileName) {
        File src = new File(PATH_TO_DIRECTORY + srcFileName);

        List<Person> people = ExcelReader.excelReader(src);
        WordWriter wordWriter = new WordWriter();
        wordWriter.createDoc(PATH_TO_TEMPLATE, people);
    }
}
