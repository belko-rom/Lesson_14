package ExtraTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExtraTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу(для простоты введите: src/ExtraTask/documentNumber.txt): ");
        String inputFilePath = scanner.nextLine();


        File inputFile = new File(inputFilePath);

        //Создаем два FileWriter для записи валидных и невалидных номеров документов в отчеты

        File validOutputFile = new File("src/ExtraTask/valid_numbers.txt");
        File invalidOutputFile = new File("src/ExtraTask/invalid_numbers.txt");

        try (Scanner fileScanner = new Scanner(inputFile);
             FileWriter validFileWriter = new FileWriter(validOutputFile);
             FileWriter invalidFileWriter = new FileWriter(invalidOutputFile)) {
            //Считываем номера документов из входного файла построчно
            while (fileScanner.hasNextLine()) {
                String documentNumber = fileScanner.nextLine();

                if (isValidDocumentNumber(documentNumber)) {
                    validFileWriter.write(documentNumber + "\n");
                } else {
                    invalidFileWriter.write(documentNumber + " - Невалидный номер документа\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Проверяем каждый номер документа на валидность с помощью регулярного выражения
    private static boolean isValidDocumentNumber(String documentNumber) {
        return Pattern.matches("^(docnum|contract)[a-zA-Z0-9]{13}$", documentNumber);
    }
}
