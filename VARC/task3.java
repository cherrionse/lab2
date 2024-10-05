package VARC;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printArray(array);

        findLongestSequence(array);
    }

    public static void findLongestSequence(int[][] array) {
        int n = array.length;
        int longestInc = 1, longestDec = 1;

        for (int i = 0; i < n; i++) {
            int currentInc = 1, currentDec = 1;

            for (int j = 1; j < n; j++) {
                // Проверяем последовательность возрастания
                if (array[i][j] > array[i][j - 1]) {
                    currentInc++;
                } else {
                    currentInc = 1;
                }
                longestInc = Math.max(longestInc, currentInc);

                // Проверяем последовательность убывания
                if (array[i][j] < array[i][j - 1]) {
                    currentDec++;
                } else {
                    currentDec = 1;
                }
                longestDec = Math.max(longestDec, currentDec);
            }
        }

        System.out.println("Наибольшая возрастающая последовательность: " + longestInc);
        System.out.println("Наибольшая убывающая последовательность: " + longestDec);
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
