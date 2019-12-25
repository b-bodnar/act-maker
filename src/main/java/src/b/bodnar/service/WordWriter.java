package src.b.bodnar.service;

import lombok.NonNull;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;
import src.b.bodnar.model.Person;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class WordWriter {
    private File desktop = new File(System.getProperty("user.home"), "Desktop");

    public void createDoc(String template, @NonNull List<Person> persons) {
        File folderForActs = createFolder();
        Docx act = null;
        try {
            for (Person person : persons) {
                act = new Docx(template);
                act.setVariablePattern(new VariablePattern("#{", "}"));
                Variables variables = fillVariable(person);
                act.fillTemplate(variables);
                File realiseFile = new File(desktop.getAbsolutePath()
                        + File.separator
                        + folderForActs.getName()
                        + File.separator
                        + person.getApartment().getApartmentNumber() + " "
                        + person.getFullName() + ".docx");
                System.out.println(person.getApartment().getApartmentNumber());
                realiseFile.createNewFile();
                act.save(realiseFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Variables fillVariable(Person person) {
        Variables variables = new Variables();
        variables.addTextVariable(
                new TextVariable("#{flor}", person.getApartment().getFlor()));
        variables.addTextVariable(
                new TextVariable("#{section}", person.getApartment().getSection()));
        variables.addTextVariable(
                new TextVariable("#{apartmentNumber}", person.getApartment().getApartmentNumber()));
        variables.addTextVariable(
                new TextVariable("#{countRooms}", person.getApartment().getCountRooms()));
        variables.addTextVariable(
                new TextVariable("#{totalArea}", person.getApartment().getTotalArea()));
        variables.addTextVariable(
                new TextVariable("#{livingArea}", person.getApartment().getLivingArea()));
        variables.addTextVariable(
                new TextVariable("#{fullName}", person.getFullName()));
        variables.addTextVariable(
                new TextVariable("#{passport}", person.getPassport()));
        variables.addTextVariable(
                new TextVariable("#{address}", person.getAddress()));
        variables.addTextVariable(
                new TextVariable("#{taxID}", person.getTaxID()));
        return variables;
    }

    private File createFolder() {
        var calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(calendar.getTime());
        File folderForActs = new File(desktop.getAbsolutePath() + File.separator + currentDate);
        if(folderForActs.exists()){
            folderForActs.delete();
        }
        folderForActs.mkdir();
        return folderForActs;
    }
}
