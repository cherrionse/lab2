package VARC;
import functions.Matrix;

import java.util.Random;
import java.util.Scanner;

public class Task12 {
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
        System.out.println("Задание 12: Найти минимальный элемент и переместить его на заданную позицию.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Поиск минимального элемента
        int minElement = Integer.MAX_VALUE;
        int minRow = -1, minCol = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < minElement) {
                    minElement = array[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        System.out.println("Минимальный элемент: " + minElement + " в позиции (" + minRow + ", " + minCol + ")");

        System.out.print("Введите новую позицию для минимального элемента (строка и столбец): ");
        int newRow = scanner.nextInt();
        int newCol = scanner.nextInt();

        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
            System.out.println("Неверная позиция.");
            return;
        }

        // Перемещение минимального элемента
        array[minRow][minCol] = array[newRow][newCol];
        array[newRow][newCol] = minElement;

        System.out.println("Матрица после перемещения минимального элемента:");
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

