package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 18: Перестроить матрицу, переставляя столбцы так, чтобы суммы модулей их элементов убывали.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Сортировка столбцов по убыванию суммы модулей их элементов
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (getColumnSum(matrix, i) < getColumnSum(matrix, j)) {
                    swapColumns(matrix, i, j);
                }
            }
        }

        System.out.println("Матрица после перестановки столбцов:");
        printMatrix(matrix);
    }

    // Метод для подсчета суммы модулей элементов столбца
    public static int getColumnSum(int[][] matrix, int col) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += Math.abs(row[col]);
        }
        return sum;
    }

    // Метод для перестановки столбцов
    public static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(21) - 10; // Генерация чисел от -10 до 10
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }
}
