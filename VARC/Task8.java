package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task8 {
    // Вспомогательная функция для печати матрицы с double элементами
    public static void printMatrix(double[][] array) {
        for (double[] row : array) {
            for (double elem : row) {
                System.out.printf("%6.2f", elem);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 8: Вычислить определитель матрицы.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        double[][] array = new double[n][n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextDouble() * 10; // случайные числа от 0 до 10
            }
        }

        System.out.println("Матрица:");
        printMatrix(array);
        double determinant = calculateDeterminant(array);
        System.out.printf("Определитель матрицы: %.2f%n", determinant);
    }

    // Функция для вычисления определителя
    public static double calculateDeterminant(double[][] array) {
        int n = array.length;
        double det = 0;

        if (n == 1) {
            return array[0][0];
        } else if (n == 2) {
            return array[0][0] * array[1][1] - array[0][1] * array[1][0];
        } else {
            for (int i = 0; i < n; i++) {
                det += Math.pow(-1, i) * array[0][i] * calculateDeterminant(getMinor(array, 0, i));
            }
        }
        return det;
    }

    // Функция для получения минорной матрицы
    public static double[][] getMinor(double[][] array, int row, int col) {
        int n = array.length;
        double[][] minor = new double[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[i < row ? i : i - 1][j < col ? j : j - 1] = array[i][j];
            }
        }
        return minor;
    }
}
