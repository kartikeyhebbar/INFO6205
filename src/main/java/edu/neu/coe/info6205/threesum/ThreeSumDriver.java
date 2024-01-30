package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;

import java.util.Arrays;

public class ThreeSumDriver {

    public static void main(String[] args) {
        // arrays to test code performance
        int[] arr = {-2, 0, 2};
//        int[] arr = {1, 2, -3, -1, 5, -4};
//        int[] arr = {10, 1, -10, 20, 0, 2, -3, -20, 30, 15, -5, 3};
//        int[] arr = {0, 1, 2, -3, 4, 5, -6, 7, 8, -9, 10, 11, 12, -13, -14, -15, 16, 17, 18, -19, 20, 21, -22, 23};
//        int[] arr = {10, -35, 18, 29, -26, -16, 48, 14, -11, 4, -4, 1, 32, 40, 26, 28, -28, -3, 45, 6, 10, 4, 2, 48, -34, 50, 23, 35, 17, 47, 29, 19, 40, 41, 44, -2, 42, 14, 26, 22, 13, -24, 12, 13, -18, 10, 0, 49};

        System.out.println("Array: " + Arrays.toString(arr));
        try(Stopwatch stopwatch = new Stopwatch()) {
            ThreeSumCubic threeSumCubic = new ThreeSumCubic(arr);
            Triple[] cubicResult = threeSumCubic.getTriples();
            System.out.println(Arrays.toString(cubicResult));
            System.out.println("Time taken by cubic method: " + stopwatch.lap() + " milliseconds.");

            ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(arr);
            Triple[] quadraticResult = threeSumQuadratic.getTriples();
            System.out.println(Arrays.toString(quadraticResult));
            System.out.println("Time taken by quadratic method: " + stopwatch.lap() + " milliseconds.");

            ThreeSumQuadrithmic threeSumQuadrithmic = new ThreeSumQuadrithmic(arr);
            Triple[] quadrithmicResult = threeSumQuadrithmic.getTriples();
            System.out.println(Arrays.toString(quadrithmicResult));
            System.out.println("Time taken by quadrithmic method: " + stopwatch.lap() + " milliseconds.");

            ThreeSumQuadraticWithCalipers threeSumQuadraticWithCalipers = new ThreeSumQuadraticWithCalipers(arr);
            Triple[] calipersResult = threeSumQuadraticWithCalipers.getTriples();
            System.out.println(Arrays.toString(calipersResult));
            System.out.println("Time taken by Quadratic with Calipers method: " + stopwatch.lap() + " milliseconds.");
        }
    }
}
