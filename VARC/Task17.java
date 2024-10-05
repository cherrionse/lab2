package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 17: Найти наименьший среди локальных максимумов.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n, n);

        System.out.println("Матрица:");
        printMatrix(matrix);

        int minLocalMax = findMinLocalMax(matrix);
        System.out.println("Наименьший среди локальных максимумов: " + minLocalMax);
    }

    // Метод для поиска наименьшего локального максимума
    public static int findMinLocalMax(int[][] matrix) {
        int n = matrix.length;
        int minLocalMax = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isLocalMaximum(matrix, i, j)) {
                    minLocalMax = Math.min(minLocalMax, matrix[i][j]);
                }
            }
        }

        return minLocalMax;
    }

    // Проверка, является ли элемент локальным максимумом
    public static boolean isLocalMaximum(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        int[] dx = {-1, 1, 0, 0}; // Смещения по строкам
        int[] dy = {0, 0, -1, 1}; // Смещения по столбцам

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length) {
                if (matrix[ni][nj] >= value) {
                    return false;
                }
            }
        }
        return true;
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
