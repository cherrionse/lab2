package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task11 {
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
        System.out.println("Задание 11: Уплотнить матрицу, удаляя нулевые строки и столбцы.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Удаление нулевых строк
        boolean[] nonZeroRows = new boolean[n];
        for (int i = 0; i < n; i++) {
            nonZeroRows[i] = false;
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0) {
                    nonZeroRows[i] = true;
                    break;
                }
            }
        }

        // Удаление нулевых столбцов
        boolean[] nonZeroCols = new boolean[n];
        for (int j = 0; j < n; j++) {
            nonZeroCols[j] = false;
            for (int i = 0; i < n; i++) {
                if (array[i][j] != 0) {
                    nonZeroCols[j] = true;
                    break;
                }
            }
        }

        // Подсчет количества оставшихся строк и столбцов
        int newRows = 0, newCols = 0;
        for (boolean row : nonZeroRows) {
            if (row) newRows++;
        }
        for (boolean col : nonZeroCols) {
            if (col) newCols++;
        }

        if (newRows == 0 || newCols == 0) {
            System.out.println("После удаления получилась пустая матрица.");
            return;
        }

        // Создание новой матрицы
        int[][] newArray = new int[newRows][newCols];
        int newI = 0;
        for (int i = 0; i < n; i++) {
            if (!nonZeroRows[i]) continue;
            int newJ = 0;
            for (int j = 0; j < n; j++) {
                if (!nonZeroCols[j]) continue;
                newArray[newI][newJ++] = array[i][j];
            }
            newI++;
        }

        System.out.println("Матрица после уплотнения:");
        printMatrix(newArray);
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

