import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    // Вспомогательная функция для получения текущей даты и времени
    public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    // Задание 1. Найти самое короткое и самое длинное число
    public static void task1(String[] numbers) {
        String shortest = numbers[0];
        String longest = numbers[0];

        for (String num : numbers) {
            if (num.length() < shortest.length()) {
                shortest = num;
            }
            if (num.length() > longest.length()) {
                longest = num;
            }
        }

        System.out.println("Самое короткое число: " + shortest + " (Длина: " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (Длина: " + longest.length() + ")");
    }

    // Задание 2. Упорядочить и вывести числа по длине
    public static void task2(String[] numbers) {
        Arrays.sort(numbers, Comparator.comparingInt(String::length));
        System.out.println("Числа по возрастанию длины: " + Arrays.toString(numbers));

        Arrays.sort(numbers, (a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println("Числа по убыванию длины: " + Arrays.toString(numbers));
    }

    // Задание 3. Числа меньше или больше средней длины
    public static void task3(String[] numbers) {
        double averageLength = Arrays.stream(numbers).mapToInt(String::length).average().orElse(0);
        System.out.println("Средняя длина: " + averageLength);

        System.out.println("Числа с длиной меньше средней:");
        for (String num : numbers) {
            if (num.length() < averageLength) {
                System.out.println(num + " (Длина: " + num.length() + ")");
            }
        }

        System.out.println("Числа с длиной больше средней:");
        for (String num : numbers) {
            if (num.length() > averageLength) {
                System.out.println(num + " (Длина: " + num.length() + ")");
            }
        }
    }

    // Задание 4. Найти число с минимальным количеством различных цифр
    public static void task4(String[] numbers) {
        String result = numbers[0];
        int minUniqueDigits = getUniqueDigitsCount(numbers[0]);

        for (String num : numbers) {
            int uniqueDigits = getUniqueDigitsCount(num);
            if (uniqueDigits < minUniqueDigits) {
                result = num;
                minUniqueDigits = uniqueDigits;
            }
        }

        System.out.println("Число с минимальным количеством различных цифр: " + result);
    }

    // Вспомогательная функция для подсчета уникальных цифр в числе
    private static int getUniqueDigitsCount(String number) {
        return (int) number.chars().distinct().count();
    }

    // Задание 5. Найти количество чисел, содержащих только четные цифры
    public static void task5(String[] numbers) {
        int evenCount = 0;
        int evenOddEqualCount = 0;

        for (String num : numbers) {
            boolean allEven = num.chars().allMatch(c -> (c - '0') % 2 == 0);
            if (allEven) {
                evenCount++;
                long evenDigits = num.chars().filter(c -> (c - '0') % 2 == 0).count();
                long oddDigits = num.length() - evenDigits;
                if (evenDigits == oddDigits) {
                    evenOddEqualCount++;
                }
            }
        }

        System.out.println("Чисел, содержащих только четные цифры: " + evenCount);
        System.out.println("Чисел с равным числом четных и нечетных цифр: " + evenOddEqualCount);
    }

    // Задание 6. Найти число, цифры в котором идут в строгом порядке возрастания
    public static void task6(String[] numbers) {
        for (String num : numbers) {
            if (isAscendingOrder(num)) {
                System.out.println("Число с цифрами в строгом порядке возрастания: " + num);
                return;
            }
        }
        System.out.println("Чисел с цифрами в строгом порядке возрастания не найдено.");
    }

    // Вспомогательная функция для проверки порядка возрастания цифр
    private static boolean isAscendingOrder(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Задание 7. Найти число, состоящее только из различных цифр
    public static void task7(String[] numbers) {
        for (String num : numbers) {
            if (num.chars().distinct().count() == num.length()) {
                System.out.println("Число, состоящее только из различных цифр: " + num);
                return;
            }
        }
        System.out.println("Чисел, состоящих только из различных цифр, не найдено.");
    }

    // Задание 8. Найти второе число-палиндром
    public static void task8(String[] numbers) {
        int palindromeCount = 0;

        for (String num : numbers) {
            if (isPalindrome(num)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    System.out.println("Второе число-палиндром: " + num);
                    return;
                }
            }
        }

        System.out.println("Второго числа-палиндрома не найдено.");
    }

    // Вспомогательная функция для проверки, является ли число палиндромом
    private static boolean isPalindrome(String number) {
        return number.equals(new StringBuilder(number).reverse().toString());
    }

    // Задание 9. Найти корни квадратного уравнения
    public static void task9(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни уравнения: " + root1 + ", " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Единственный корень: " + root);
        } else {
            System.out.println("Уравнение не имеет вещественных корней.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получение данных для первого задания
        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Перевод строки
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers[i] = scanner.nextLine();
        }

        // Выполнение всех задач поочередно
        System.out.println("\nЗадание 1:");
        task1(numbers);

        System.out.println("\nЗадание 2:");
        task2(numbers);

        System.out.println("\nЗадание 3:");
        task3(numbers);

        System.out.println("\nЗадание 4:");
        task4(numbers);

        System.out.println("\nЗадание 5:");
        task5(numbers);

        System.out.println("\nЗадание 6:");
        task6(numbers);

        System.out.println("\nЗадание 7:");
        task7(numbers);

        System.out.println("\nЗадание 8:");
        task8(numbers);

        // Ввод коэффициентов для квадратного уравнения
        System.out.println("\nЗадание 9. Введите коэффициенты для квадратного уравнения (a, b, c):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        task9(a, b, c);

        // Вывод текущей даты и времени
        System.out.println("\nРазработчик: Муминов И.И.");
        System.out.println("\nДата сдачи задания: " + getCurrentDateTime());
    }
}
