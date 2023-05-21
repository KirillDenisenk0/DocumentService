package DriverLicense;


import javax.print.Doc;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DocumentService {

    List<Document> documentList = new ArrayList<>();


    public void listInitialization() {
        String path = "C:\\Users\\Bulbazaur1\\IdeaProjects\\TrainingProject\\src\\DriverLicense\\Documents";
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                String data = br.readLine();
                String[] array = data.split(",");
                if (array[0].equalsIgnoreCase("passport")) {
                    documentList.add(new Passport(array[0], array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4])));
                } else if (array[0].equalsIgnoreCase("driver license")) {
                    documentList.add(new DriverLicense(array[0], array[1], array[2], Integer.parseInt(array[3])));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Document> showAllPassport() {
        List<Document> passport = documentList.stream().filter(val -> val.getNameOfDocument().equalsIgnoreCase("passport")).toList();
        return passport;
    }

    public List<Document> showAllDriverLicense() {
        List<Document> driverLicenseList = documentList.stream().filter(val -> val.getNameOfDocument().equalsIgnoreCase("driver license")).toList();
        return driverLicenseList;
    }


    public void deleteOnNumberSeries(int series, int number) {
        Passport passport = new Passport("passport", series, number);
        if (documentList.contains(passport)) {
            documentList.remove(passport);
            System.out.println("Паспорт с номером: " + number + " и серией: " + series + " успешно удалён.");
        } else {
            System.out.println("Паспорт не найден, попробуйте снова.");
        }
    }

    public void deleteOnUniqueNumber(int uniqueDriversLicenseNumber) {
        DriverLicense driverLicense = new DriverLicense("drivers license", uniqueDriversLicenseNumber);
        if (documentList.contains(driverLicense)) {
            documentList.remove(driverLicense);
            System.out.println("Водительское удостоверение с номером: " + uniqueDriversLicenseNumber + " успешно удалено.");
        } else {
            System.out.println("удостоверение с номером: " + uniqueDriversLicenseNumber + " не найдено, попробуйте снова.");
        }
    }

    public void showOnSeriesNumber(int series, int number) {
        Passport passport = new Passport("passport", series, number);
        if (documentList.contains(passport)) {
            String name = documentList.get(documentList.indexOf(passport)).getNameOfOwner();
            String lastName = documentList.get(documentList.indexOf(passport)).getLastnameOfOwner();
            System.out.println("Имя владельца: " + name + " , фамилия владельца: " + lastName);
        } else {
            System.out.println("Пользователь не найден, попробуйте снова.");
        }
    }

    public void changeNameOnNumber(int number, String preferredLastName) {
        Passport passport = new Passport("passport", number);
        if (documentList.contains(passport)) {
            Document searchPassport = documentList.get(documentList.indexOf(passport));
            passport = (Passport) searchPassport;
            documentList.set(documentList.indexOf(passport), new Passport("passport", passport.getNameOfOwner(), preferredLastName, passport.getSeries(), number));
            System.out.println("Имя владельца успешно заменено.");
            //  System.out.println("Имя владельца успешно изменено с " + старое_имя + " на " + preferredName);  <- как сделать?
        } else {
            System.out.println("Паспорта с данным номером нет в базе данных, попробуйте снова.");
        }
    }

    public void exitSave() {
        String path = "C:\\Users\\Bulbazaur1\\IdeaProjects\\TrainingProject\\src\\DriverLicense\\Documents";
        Path path1 = Path.of(path);
        try (PrintWriter printWriter = new PrintWriter(path)) {
            StringBuilder str = new StringBuilder("");
            for (Document document : documentList) {
                if (document instanceof Passport) {
                    printWriter.println("Passport" + "," + document.getNameOfOwner() + ","
                            + document.getLastnameOfOwner() + "," + ((Passport) document).getSeries() + "," + ((Passport) document).getNumber());
                } else if (document instanceof DriverLicense) {
                    printWriter.println("Driver license" + "," + document.getNameOfOwner() + "," + document.getLastnameOfOwner() + "," + ((DriverLicense) document).getUniqueNumberOfLicense());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
        passport,John,Johnson,2715,156594
        passport,Andrew,Tate,9872,238392
        driver license,Mahadi,Rakib,456798
        driver license, Bob, Clinton,938423*/
