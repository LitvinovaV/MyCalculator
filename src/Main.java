import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ответ: " + calc(scanner.nextLine()));
    }

    public static String calc(String input) throws IllegalStateException, IOException {
        String[] arrStr = input.split(" ");//разделяем строку по пробелам и создаем массив
        Roman rom = new Roman();
        Check ch = new Check();
        Arabic ar = new Arabic();
        int number1;
        int number2;
        int result;
        String output;
        if (arrStr.length != 3) {
            throw new IOException("Вводимое выражение не удовлетворяет заданию");
        }
        if (ch.checkIt(arrStr[0]) == -1 && ch.checkIt(arrStr[2]) == -1) {// проверяем, введенное выражение содержит римские или арабские числа
            number1 = Integer.parseInt(arrStr[0]);
            number2 = Integer.parseInt(arrStr[2]);
        } else {
            number1 = (rom.translateInt(arrStr[0]));
            number2 = (rom.translateInt(arrStr[2]));
        }
        if (number1 == 0 || number2 == 0 || number1 > 10 || number2 > 10) {
            throw new IOException("Вводимое число не удовлетворяет заданию");
        }
        result = switch (arrStr[1]) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> throw new IllegalStateException("Строка не является математической операцией");
        };
        if (ch.checkIt(arrStr[0]) == -1 && ch.checkIt(arrStr[2]) == -1) {
            output = Integer.toString(result); //метод calc возвращмет переменную типа данных String
        } else {
            if (result == 100) {
                output = ar.countTens(result / 10);
            } else if (result / 10 != 0) {
                output = ar.countTens(result / 10) + ar.countUnits(result % 10);
            } else {
                if (result < 1) {
                    throw new IOException("Ошибка ввода математического выражения");
                }
                output = ar.countUnits(result);
            }
        }
        return output;
    }
}
