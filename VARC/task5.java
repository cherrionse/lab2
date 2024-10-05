package VARC;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы N: ");
        int n = scanner.nextInt();

        System.out.print("Введите максимальное значение k: ");
        int k = scanner.nextInt();

        fillMatrix(n, k);
    }

    public static void fillMatrix(int n, int k) {
        int[][] array = new int[n][n];
        int value = 1;

        for (int i = 0; i < n && value <= k; i++) {
            for (int j = 0; j < n && value <= k; j++) {
                array[i][j] = value++;
            }
        }

        printArray(array);
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }
}
