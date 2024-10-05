package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task9 {
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
        System.out.println("Задание 9: Построить матрицу, вычитая среднее арифметическое из элементов строки.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        double[][] array = new double[n][n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextDouble() * 20 - 10; // случайные числа от -10 до 10
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(array);

        // Вычитание среднего арифметического из каждой строки
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += array[i][j];
            }
            double average = sum / n;
            for (int j = 0; j < n; j++) {
                array[i][j] -= average;
            }
        }

        System.out.println("Матрица после вычитания среднего арифметического из каждой строки:");
        printMatrix(array);
    }
}
