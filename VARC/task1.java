package VARC;
import java.util.Arrays;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printArray(array);

        System.out.print("Выберите 1 для сортировки строк, 2 для сортировки столбцов: ");
        int choice = scanner.nextInt();

        System.out.print("Введите индекс строки или столбца k (начиная с 0): ");
        int k = scanner.nextInt();

        if (choice == 1) {
            // Сортировка строк по k-ому столбцу
            Arrays.sort(array, (a, b) -> Integer.compare(a[k], b[k]));
        } else if (choice == 2) {
            // Сортировка столбцов по k-ой строке
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (array[k][i] > array[k][j]) {
                        for (int l = 0; l < n; l++) {
                            int temp = array[l][i];
                            array[l][i] = array[l][j];
                            array[l][j] = temp;
                        }
                    }
                }
            }
        }

        System.out.println("Матрица после сортировки:");
        printArray(array);
    }

    public static int[][] generateArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = (int) (Math.random() * 21 - 10);
            }
        }
        return array;
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
