package VARC;
import java.util.Random;
import java.util.Scanner;

public class Task7 {
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
        System.out.println("Задание 7: Поворот матрицы на 90, 180 или 270 градусов против часовой стрелки.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(10); // случайные числа от 0 до 9
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(array);

        System.out.print("Введите угол поворота (90, 180 или 270): ");
        int angle = scanner.nextInt();
        int[][] rotatedArray = null;

        switch (angle) {
            case 90:
                rotatedArray = rotateMatrix90(array);
                break;
            case 180:
                rotatedArray = rotateMatrix180(array);
                break;
            case 270:
                rotatedArray = rotateMatrix270(array);
                break;
            default:
                System.out.println("Неверный угол поворота.");
                return;
        }

        System.out.println("Матрица после поворота на " + angle + " градусов:");
        printMatrix(rotatedArray);
    }

    // Функция для поворота матрицы на 90 градусов
    public static int[][] rotateMatrix90(int[][] array) {
        int n = array.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = array[i][j];
            }
        }
        return rotated;
    }

    // Функция для поворота матрицы на 180 градусов
    public static int[][] rotateMatrix180(int[][] array) {
        int n = array.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - i][n - 1 - j] = array[i][j];
            }
        }
        return rotated;
    }

    // Функция для поворота матрицы на 270 градусов
    public static int[][] rotateMatrix270(int[][] array) {
        int n = array.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = array[i][j];
            }
        }
        return rotated;
    }
}
