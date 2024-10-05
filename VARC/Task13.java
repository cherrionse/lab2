package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task13 {
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
        System.out.println("Задание 13: Перестановка нулей в конце каждой строки.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Перестановка нулей в конце каждой строки
        for (int i = 0; i < n; i++) {
            int[] newRow = new int[n];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0) {
                    newRow[index++] = array[i][j];
                }
            }
            array[i] = newRow;
        }

        System.out.println("Матрица после перестановки нулей в конце каждой строки:");
        printMatrix(array);
    }

    // Вспомогательная функция для генерации матрицы
    public static int[][] generateArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(11); // Генерация чисел от 0 до 10
            }
        }
        return array;
    }
}
