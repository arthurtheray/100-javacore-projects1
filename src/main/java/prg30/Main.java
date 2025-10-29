package prg30;

import java.util.Arrays;

/**
 * Двумерная матрица. Транспонирование.
 *    1. Требования: `int[][]`; без коллекций.
 *    2. Теория: зубчатые массивы, индексация `[i][j]`, обмен элементов.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(6, 2);
        System.out.println("Исходная матрица:");
        printMatrix(matrix);
        System.out.println("Транспонированная матрица:");
        printMatrix(transposeMatrix(matrix));

        //tests:
//        int[][] toothArray = new int[3][];
//        toothArray[0] = new int[] {1, 2, 2, 2};
//        toothArray[1] = new int[] {3, 4, 5, 5};
//        toothArray[2] = new int[] {6, 6, 6, 6};
//        System.out.println(Arrays.deepToString(transposeMatrix(toothArray)));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i].length != matrix[i + 1].length) {
                throw new IllegalArgumentException("зубчатые массивы не допускаются. Все подмассивы должны быь одной длины");
            }
        }
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }

        }

        return transposed;
    }

    private static int[][] generateMatrix(int lenX, int lenY) {
        if (lenX == 0 || lenY == 0) {
            throw new IllegalArgumentException("размер матрицы по каждой оси н может быть нулевым");
        }

        int[][] res = new int[lenX][lenY];
        for (int[] row : res) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (int) (Math.random() * 10);
            }
        }
        return res;
    }
}
