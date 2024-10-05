package VARC;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printArray(array);

        int sum = calculateSumBetweenPositives(array);
        System.out.println("Сумма элементов между первым и вторым положительными элементами: " + sum);
    }

    public static int calculateSumBetweenPositives(int[][] array) {
        int sum = 0;

        for (int[] row : array) {
            int firstPos = -1, secondPos = -1;

            for (int i = 0; i < row.length; i++) {
                if (row[i] > 0) {
                    if (firstPos == -1) {
                        firstPos = i;
                    } else if (secondPos == -1) {
                        secondPos = i;
                        break;
                    }
                }
            }

            if (firstPos != -1 && secondPos != -1 && secondPos > firstPos + 1) {
                for (int i = firstPos + 1; i < secondPos; i++) {
                    sum += row[i];
                }
            }
        }

        return sum;
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
