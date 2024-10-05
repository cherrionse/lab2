package VARC;
import java.util.Random;
import java.util.Scanner;

public class task6 {
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
        System.out.println("Задание 6: Округление всех элементов матрицы до целого числа.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        double[][] array = new double[n][n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextDouble() * 10; // случайные числа от 0 до 10
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Округление элементов
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.round(array[i][j]);
            }
        }

        System.out.println("Матрица после округления:");
        printMatrix(array);
    }
}
