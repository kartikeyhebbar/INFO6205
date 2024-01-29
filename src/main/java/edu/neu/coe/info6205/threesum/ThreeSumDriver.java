package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;

import java.util.Arrays;

public class ThreeSumDriver {

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, -1, 5, -4};
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
