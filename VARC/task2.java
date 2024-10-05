package VARC;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = generateArray(n, n);

        System.out.println("Исходная матрица:");
        printArray(array);

        System.out.print("Введите количество позиций для сдвига k: ");
        int k = scanner.nextInt();

        System.out.print("Выберите направление сдвига (1 - вправо, 2 - влево, 3 - вверх, 4 - вниз): ");
        int direction = scanner.nextInt();

        shiftArray(array, k, direction);

        System.out.println("Матрица после сдвига:");
        printArray(array);
    }

    public static void shiftArray(int[][] array, int k, int direction) {
        int n = array.length;
        for (int i = 0; i < k; i++) {
            if (direction == 1) {
                shiftRight(array);
            } else if (direction == 2) {
                shiftLeft(array);
            } else if (direction == 3) {
                shiftUp(array);
            } else if (direction == 4) {
                shiftDown(array);
            }
        }
    }

    public static void shiftRight(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[i][n - 1];
            for (int j = n - 1; j > 0; j--) {
                array[i][j] = array[i][j - 1];
            }
            array[i][0] = temp;
        }
    }

    public static void shiftLeft(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[i][0];
            for (int j = 0; j < n - 1; j++) {
                array[i][j] = array[i][j + 1];
            }
            array[i][n - 1] = temp;
        }
    }

    public static void shiftUp(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[0][i];
            for (int j = 0; j < n - 1; j++) {
                array[j][i] = array[j + 1][i];
            }
            array[n - 1][i] = temp;
        }
    }

    public static void shiftDown(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[n - 1][i];
            for (int j = n - 1; j > 0; j--) {
                array[j][i] = array[j - 1][i];
            }
            array[0][i] = temp;
        }
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
