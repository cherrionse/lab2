import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Задания для Варианта B
*/

public class varb {

    // Вспомогательная функция для получения текущей даты и времени
    public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    // Задание 1. Вывести на экран таблицу умножения
    public static void task1() {
        System.out.println("Задание 1. Таблица умножения:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    // Задание 2. Вывести элементы массива в обратном порядке
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 2. Вывод элементов массива в обратном порядке.");
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Ввод элементов массива
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Вывод массива в обратном порядке
        System.out.println("Элементы массива в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Задание 3. Определить принадлежность значения k интервалам
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 3. Проверка принадлежности числа k интервалам.");
        System.out.print("Введите значение k: ");
        double k = scanner.nextDouble();
        System.out.print("Введите значение n: ");
        double n = scanner.nextDouble();
        System.out.print("Введите значение m: ");
        double m = scanner.nextDouble();

        // Проверка принадлежности к разным интервалам
        System.out.println("Принадлежность k интервалам:");
        System.out.println("Интервал (n, m]: " + ((k > n && k <= m) ? "Да" : "Нет"));
        System.out.println("Интервал [n, m): " + ((k >= n && k < m) ? "Да" : "Нет"));
        System.out.println("Интервал (n, m): " + ((k > n && k < m) ? "Да" : "Нет"));
        System.out.println("Интервал [n, m]: " + ((k >= n && k <= m) ? "Да" : "Нет"));
    }

    // Задание 4. Вывести числа от 1 до 100, делящиеся на 3 без остатка
    public static void task4() {
        System.out.println("Задание 4. Числа от 1 до 100, делящиеся на 3 без остатка:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Задание 5. Количество значащих нулей в двоичной записи числа 129
    public static void task5() {
        int number = 129;
        String binary = Integer.toBinaryString(number);
        long trailingZeros = binary.chars().filter(c -> c == '0').count();
        System.out.println("Задание 5. Количество значащих нулей в двоичной записи числа 129:");
        System.out.println("Число 129 в двоичной системе: " + binary);
        System.out.println("Количество значащих нулей: " + trailingZeros);
    }

    // Задание 6. Найти основание системы счисления, при котором 81 записывается как 100
    public static void task6() {
        System.out.println("Задание 6. Найти основание системы счисления, при котором 81 = 100.");
        int decimalNumber = 81;
        for (int base = 2; base <= 16; base++) {
            String representation = Integer.toString(decimalNumber, base);
            if (representation.equals("100")) {
                System.out.println("Основание системы счисления: " + base);
                return;
            }
        }
        System.out.println("Подходящее основание системы счисления не найдено в диапазоне 2-16.");
    }

    // Задание 7. Перевод числа из десятичной системы счисления в любую другую
    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 7. Перевод числа из десятичной системы в другую.");
        System.out.print("Введите десятичное число: ");
        int number = scanner.nextInt();
        System.out.print("Введите основание целевой системы счисления (2-36): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 36) {
            System.out.println("Недопустимое основание системы счисления.");
            return;
        }

        String converted = Integer.toString(number, base).toUpperCase();
        System.out.println("Число " + number + " в системе счисления с основанием " + base + ": " + converted);
    }

    // Задание 8. Перевод числа из одной системы счисления в любую другую
    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 8. Перевод числа из одной системы счисления в другую.");
        System.out.print("Введите число: ");
        String number = scanner.next();
        System.out.print("Введите основание исходной системы счисления (2-36): ");
        int sourceBase = scanner.nextInt();
        System.out.print("Введите основание целевой системы счисления (2-36): ");
        int targetBase = scanner.nextInt();

        try {
            int decimal = Integer.parseInt(number, sourceBase);
            String converted = Integer.toString(decimal, targetBase).toUpperCase();
            System.out.println("Число " + number + " из системы " + sourceBase + " в систему " + targetBase + ": " + converted);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод числа или оснований систем счисления.");
        }
    }

    // Задание 9. Вывести название месяца по номеру с проверкой корректности
    public static void task9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 9. Вывод названия месяца по номеру.");
        System.out.print("Введите номер месяца (1-12): ");
        int month = scanner.nextInt();

        String[] months = {
                "Январь", "Февраль", "Март", "Апрель",
                "Май", "Июнь", "Июль", "Август",
                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        if (month >= 1 && month <= 12) {
            System.out.println("Месяц: " + months[month - 1]);
        } else {
            System.out.println("Некорректный номер месяца.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод информации о разработчике и датах
        System.out.println("Разработчик: Муминов Р.И.");
        System.out.println("Дата получения задания: 2024-09-14 14:00");
        System.out.println("\nДата сдачи задания: " + getCurrentDateTime());

        // Выполнение всех заданий поочередно
        task1();
        System.out.println("\n-----------------------------\n");

        task2();
        System.out.println("\n-----------------------------\n");

        task3();
        System.out.println("\n-----------------------------\n");

        task4();
        System.out.println("\n-----------------------------\n");

        task5();
        System.out.println("\n-----------------------------\n");

        task6();
        System.out.println("\n-----------------------------\n");

        task7();
        System.out.println("\n-----------------------------\n");

        task8();
        System.out.println("\n-----------------------------\n");

        task9();
        System.out.println("\n-----------------------------\n");

        // Вывод даты и времени сдачи задания
        System.out.println("Дата сдачи задания: " + getCurrentDateTime());
    }
}
