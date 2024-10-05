package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task15 {
    // Вспомогательная функция для печати матрицы с целыми числами
    public static void printMatrix(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 15: Перестроить матрицу по сумме элементов строк.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Подсчет суммы элементов каждой строки
        int[] rowSums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += array[i][j];
            }
        }

        // Сортировка строк по возрастанию суммы элементов
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rowSums[i] > rowSums[j]) {
                    // Меняем строки местами
                    int[] tempRow = array[i];
                    array[i] = array[j];
                    array[j] = tempRow;

                    // Меняем суммы местами
                    int tempSum = rowSums[i];
                    rowSums[i] = rowSums[j];
                    rowSums[j] = tempSum;
                }
            }
        }

        System.out.println("Матрица после перестановки строк по сумме элементов:");
        printMatrix(array);
    }

    // Вспомогательная функция для генерации матрицы
    public static int[][] generateArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(21) - 10; // Генерация чисел от -10 до 10
            }
        }
        return array;
    }
}
