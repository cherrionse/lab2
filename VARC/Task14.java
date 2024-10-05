package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task14 {
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
        System.out.println("Задание 14: Найти количество седловых точек матрицы.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        int saddlePoints = 0;

        // Поиск седловых точек
        for (int i = 0; i < n; i++) {
            // Найти минимум в строке
            int rowMin = array[i][0];
            int minCol = 0;
            for (int j = 1; j < n; j++) {
                if (array[i][j] < rowMin) {
                    rowMin = array[i][j];
                    minCol = j;
                }
            }

            // Проверить, является ли этот элемент максимумом в столбце
            boolean isSaddle = true;
            for (int k = 0; k < n; k++) {
                if (array[k][minCol] > rowMin) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                saddlePoints++;
            }
        }

        System.out.println("Количество седловых точек: " + saddlePoints);
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
