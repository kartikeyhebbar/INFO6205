package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Timer;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InsertionSortDriver {

    // helper function to generate a random array
    public static Integer[] generateRandomArray(int n, int bound) {
        Random random = new Random();
        Integer[] array = new Integer[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    // helper function to generate an ordered array
    public static Integer[] generateOrderedArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    // helper function to generate a partially ordered array
    // shuffleCount specifies how many elements need to be shuffled in the ordered array to make it a partially ordered array
    public static Integer[] generatePartiallyOrderedArray(int n, int shuffleCount) {
        Integer[] array = new Integer[n];

        // get an ordered array
        array = generateOrderedArray(n);

        // Shuffle a specified number of elements randomly
        Random random = new Random();
        for (int i = 0; i < shuffleCount; i++) {
            int index1 = random.nextInt(n);
            int index2 = random.nextInt(n);

            // Swap elements at index1 and index2
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    // helper function to generate a reverse ordered array
    public static Integer[] generateReverseOrderedArray(int n) {
        Integer[] array = new Integer[n];
        int j = 0;
        for (int i = n-1; i >= 0; i--) {
            array[j] = i;
            j++;
        }
        return array;
    }

    // utility function to show the array state
    public static void printArray(Integer[] arr) {
        for(Integer element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        int m = 5;     // size of array being considered
        int n = 5;      // change this as per the doubling method to benchmark

        // *** Case 1: Random Ordered Array ***
        System.out.println("Implementing " + InsertionSort.DESCRIPTION + " using a Random Array.");
        Integer[] randomOrderedArray = generateRandomArray(m, 20);
        Supplier<Integer[]> randomOrderedArraySupplier = () -> randomOrderedArray;
        Consumer<Integer[]> randomOrderSortConsumer = InsertionSort::sort;
        Function<Integer[], Void> randomOrderSortFunction = array -> {
            randomOrderSortConsumer.accept(array);
            return null; // The result is always null, as sort method returns void
        };
        // Print the input array
        System.out.println("Input Array: ");
        printArray(randomOrderedArray);
        double randomOrderMeanTime = timer.repeat(n, randomOrderedArraySupplier, randomOrderSortFunction);
        System.out.println("Mean time of execution when n = " + n + " : " + randomOrderMeanTime + " milliseconds");
        // Print the sorted array
        System.out.println("The sorted array is: ");
        printArray(randomOrderedArray);
        System.out.println();

        // *** Case 2: Ordered Array ***
        System.out.println("Implementing " + InsertionSort.DESCRIPTION + " using an Ordered Array.");
        Integer[] orderedArray = generateOrderedArray(m);
        Supplier<Integer[]> orderedArraySupplier = () -> orderedArray;
        Consumer<Integer[]> orderedSortConsumer = InsertionSort::sort;
        Function<Integer[], Void> orderedSortFunction = array -> {
            orderedSortConsumer.accept(array);
            return null;
        };
        // Print the input array
        System.out.println("Input Array: ");
        printArray(orderedArray);
        double orderedMeanTime = timer.repeat(n, orderedArraySupplier, orderedSortFunction);
        System.out.println("Mean time of execution when n = " + n + " : " + orderedMeanTime + " milliseconds");
        // Print the sorted array
        System.out.println("The sorted array is: ");
        printArray(orderedArray);
        System.out.println();

        // *** Case 3: Partially Ordered Array ***
        System.out.println("Implementing " + InsertionSort.DESCRIPTION + " using a Partially Ordered Array.");
        Integer[] partiallyOrderedArray = generatePartiallyOrderedArray(m, n/2);
        Supplier<Integer[]> partiallyOrderedArraySupplier = () -> partiallyOrderedArray;
        Consumer<Integer[]> partiallyOrderedSortConsumer = InsertionSort::sort;
        Function<Integer[], Void> partiallyOrderedSortFunction = array -> {
            partiallyOrderedSortConsumer.accept(array);
            return null;
        };
        // Print the input array
        System.out.println("Input Array: ");
        printArray(partiallyOrderedArray);
        double partiallyOrderedMeanTime = timer.repeat(n, partiallyOrderedArraySupplier, partiallyOrderedSortFunction);
        System.out.println("Mean time of execution when n = " + n + " : " + partiallyOrderedMeanTime + " milliseconds");
        // Print the sorted array
        System.out.println("The sorted array is: ");
        printArray(partiallyOrderedArray);
        System.out.println();

        // *** Case 4: Reverse Ordered Array ***
        System.out.println("Implementing " + InsertionSort.DESCRIPTION + " using a Reverse Ordered Array.");
        Integer[] reverseOrdered = generateReverseOrderedArray(m);
        Supplier<Integer[]> reverseOrderedArraySupplier = () -> reverseOrdered;
        Consumer<Integer[]> reverseOrderedSortConsumer = InsertionSort::sort;
        Function<Integer[], Void> reverseOrderedSortFunction = array -> {
            reverseOrderedSortConsumer.accept(array);
            return null;
        };
        // Print the input array
        System.out.println("Input Array: ");
        printArray(reverseOrdered);
        double reverseOrderedMeanTime = timer.repeat(n, reverseOrderedArraySupplier, reverseOrderedSortFunction);
        System.out.println("Mean time of execution when n = " + n + " : " + reverseOrderedMeanTime + " milliseconds");
        // Print the sorted array
        System.out.println("The sorted array is: ");
        printArray(reverseOrdered);
        System.out.println();
    }
}
