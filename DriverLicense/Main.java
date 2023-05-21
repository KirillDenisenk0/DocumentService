package DriverLicense;

import lesson_13.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentService documentService = new DocumentService();

        documentService.listInitialization();

        int input = 0;
        while (input != 7) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Вывести все паспорта.");
            System.out.println("2. Вывести все водительские удостоверения.");
            System.out.println("3. Удалить паспорт по серии и номеру.");
            System.out.println("4. Удалить удостоверение по номеру.");
            System.out.println("5. Вывести имя и фамилию владельца паспорта по серии и номеру.");
            System.out.println("6. Изменить фамилию владельца паспорта по номеру.");
            System.out.println("7. Выход.");
            input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Список паспортов: ");
                System.out.println(documentService.showAllPassport());
            } else if (input == 2) {
                System.out.println("Список доступных водительских паспортов: ");
                System.out.println(documentService.showAllDriverLicense());
            } else if (input == 3) {
                System.out.println("Введите серию паспорта: ");
                int series = scanner.nextInt();
                System.out.println("Введите номер: ");
                int number = scanner.nextInt();
                documentService.deleteOnNumberSeries(series, number);
            } else if (input == 4) {
                System.out.println("Введите уникальный номер водительского удостоверения: ");
                int uniqueNumber = scanner.nextInt();
                documentService.deleteOnUniqueNumber(uniqueNumber);
            } else if (input == 5) {
                System.out.println("Введите серию документа: ");
                int series = scanner.nextInt();
                System.out.println("Введите номер документа: ");
                int number = scanner.nextInt();
                documentService.showOnSeriesNumber(series, number);
            } else if (input == 6) {
                System.out.println("Введите номер паспорта: ");
                int number = scanner.nextInt();
                System.out.println("Введите предпочитаемую фамилию: ");
                String preferredLastName = scanner.next();
                documentService.changeNameOnNumber(number, preferredLastName);
            } else if (input == 7) {
                documentService.exitSave();
                System.out.println("Данные сохранены в файл.");
                break;
            }
        }
    }
}
