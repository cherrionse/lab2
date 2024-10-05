package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
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
        System.out.println("Задание 10: Найти максимальный элемент в матрице и удалить строки и столбцы с ним.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Поиск максимального элемента
        int maxElement = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] > maxElement) {
                    maxElement = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Максимальный элемент: " + maxElement + " в позиции (" + maxRow + ", " + maxCol + ")");

        // Удаление строки и столбца с максимальным элементом
        int[][] newArray = new int[n - 1][n - 1];
        int newI = 0;
        for (int i = 0; i < n; i++) {
            if (i == maxRow) continue;
            int newJ = 0;
            for (int j = 0; j < n; j++) {
                if (j == maxCol) continue;
                newArray[newI][newJ] = array[i][j];
                newJ++;
            }
            newI++;
        }

        System.out.println("Матрица после удаления строки и столбца с максимальным элементом:");
        printMatrix(newArray);
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
