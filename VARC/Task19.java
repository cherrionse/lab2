package VARC;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 19: Перестановка элементов матрицы по убыванию.");
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n, n);

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Преобразование матрицы в одномерный массив
        int[] flatArray = new int[n * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, flatArray, i * n, n);
        }

        // Сортировка элементов в порядке убывания
        Arrays.sort(flatArray);
        reverse(flatArray);

        // Заполнение матрицы отсортированными элементами
        for (int i = 0; i < n; i++) {
            System.arraycopy(flatArray, i * n, matrix[i], 0, n);
        }

        System.out.println("Матрица после перестановки элементов по убыванию:");
        printMatrix(matrix);
    }

    // Метод для реверса массива
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
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

