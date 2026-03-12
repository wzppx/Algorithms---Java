package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PerformanceTest {

    public static void main(String[] args) {
        System.out.println("========== Original Code Performance Test ==========\n");

        testActivitySelectionOriginal();
        testCoinChangeOriginal();

        System.out.println("\n========== Optimized Code Performance Test ==========\n");

        testActivitySelectionOptimized();
        testCoinChangeOptimized();
    }

    // ==================== Original Code Tests ====================

    private static void testActivitySelectionOriginal() {
        System.out.println("----- ActivitySelection Original Performance Test -----");

        // Test 1: Small dataset
        long totalTime1 = 0;
        for (int i = 0; i < 100000; i++) {
            int[] start = {1, 3, 0, 5, 8, 5};
            int[] end = {2, 4, 6, 7, 9, 9};
            long startTime = System.nanoTime();
            ActivitySelection.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime1 += (endTime - startTime);
        }
        System.out.println("Test 1 (6 activities, 100000 runs): " + (totalTime1 / 100000) + " ns/run");

        // Test 2: Medium dataset
        long totalTime2 = 0;
        for (int i = 0; i < 10000; i++) {
            int[] start = generateRandomArray(100, 1, 200);
            int[] end = generateEndTimes(start);
            long startTime = System.nanoTime();
            ActivitySelection.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime2 += (endTime - startTime);
        }
        System.out.println("Test 2 (100 activities, 10000 runs): " + (totalTime2 / 10000) + " ns/run");

        // Test 3: Large dataset
        long totalTime3 = 0;
        for (int i = 0; i < 1000; i++) {
            int[] start = generateRandomArray(10000, 1, 20000);
            int[] end = generateEndTimes(start);
            long startTime = System.nanoTime();
            ActivitySelection.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime3 += (endTime - startTime);
        }
        System.out.println("Test 3 (10000 activities, 1000 runs): " + (totalTime3 / 1000) + " ns/run");

        System.out.println();
    }

    private static void testCoinChangeOriginal() {
        System.out.println("----- CoinChange Original Performance Test -----");

        // Test 1: Small amount
        long totalTime1 = 0;
        for (int i = 0; i < 100000; i++) {
            long startTime = System.nanoTime();
            CoinChange.coinChangeProblem(591);
            long endTime = System.nanoTime();
            totalTime1 += (endTime - startTime);
        }
        System.out.println("Test 1 (amount 591, 100000 runs): " + (totalTime1 / 100000) + " ns/run");

        // Test 2: Medium amount
        long totalTime2 = 0;
        for (int i = 0; i < 100000; i++) {
            long startTime = System.nanoTime();
            CoinChange.coinChangeProblem(9999);
            long endTime = System.nanoTime();
            totalTime2 += (endTime - startTime);
        }
        System.out.println("Test 2 (amount 9999, 100000 runs): " + (totalTime2 / 100000) + " ns/run");

        // Test 3: Large amount
        long totalTime3 = 0;
        for (int i = 0; i < 10000; i++) {
            long startTime = System.nanoTime();
            CoinChange.coinChangeProblem(1000000);
            long endTime = System.nanoTime();
            totalTime3 += (endTime - startTime);
        }
        System.out.println("Test 3 (amount 1000000, 10000 runs): " + (totalTime3 / 10000) + " ns/run");

        System.out.println();
    }

    // ==================== Optimized Code Tests ====================

    private static void testActivitySelectionOptimized() {
        System.out.println("----- ActivitySelectionOptimized Performance Test -----");

        // Test 1: Small dataset
        long totalTime1 = 0;
        for (int i = 0; i < 100000; i++) {
            int[] start = {1, 3, 0, 5, 8, 5};
            int[] end = {2, 4, 6, 7, 9, 9};
            long startTime = System.nanoTime();
            ActivitySelectionOptimized.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime1 += (endTime - startTime);
        }
        System.out.println("Test 1 (6 activities, 100000 runs): " + (totalTime1 / 100000) + " ns/run");

        // Test 2: Medium dataset
        long totalTime2 = 0;
        for (int i = 0; i < 10000; i++) {
            int[] start = generateRandomArray(100, 1, 200);
            int[] end = generateEndTimes(start);
            long startTime = System.nanoTime();
            ActivitySelectionOptimized.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime2 += (endTime - startTime);
        }
        System.out.println("Test 2 (100 activities, 10000 runs): " + (totalTime2 / 10000) + " ns/run");

        // Test 3: Large dataset
        long totalTime3 = 0;
        for (int i = 0; i < 1000; i++) {
            int[] start = generateRandomArray(10000, 1, 20000);
            int[] end = generateEndTimes(start);
            long startTime = System.nanoTime();
            ActivitySelectionOptimized.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime3 += (endTime - startTime);
        }
        System.out.println("Test 3 (10000 activities, 1000 runs): " + (totalTime3 / 1000) + " ns/run");

        System.out.println();
    }

    private static void testCoinChangeOptimized() {
        System.out.println("----- CoinChangeOptimized Performance Test -----");

        // Test 1: Small amount
        long totalTime1 = 0;
        for (int i = 0; i < 100000; i++) {
            long startTime = System.nanoTime();
            CoinChangeOptimized.coinChangeProblem(591);
            long endTime = System.nanoTime();
            totalTime1 += (endTime - startTime);
        }
        System.out.println("Test 1 (amount 591, 100000 runs): " + (totalTime1 / 100000) + " ns/run");

        // Test 2: Medium amount
        long totalTime2 = 0;
        for (int i = 0; i < 100000; i++) {
            long startTime = System.nanoTime();
            CoinChangeOptimized.coinChangeProblem(9999);
            long endTime = System.nanoTime();
            totalTime2 += (endTime - startTime);
        }
        System.out.println("Test 2 (amount 9999, 100000 runs): " + (totalTime2 / 100000) + " ns/run");

        // Test 3: Large amount
        long totalTime3 = 0;
        for (int i = 0; i < 10000; i++) {
            long startTime = System.nanoTime();
            CoinChangeOptimized.coinChangeProblem(1000000);
            long endTime = System.nanoTime();
            totalTime3 += (endTime - startTime);
        }
        System.out.println("Test 3 (amount 1000000, 10000 runs): " + (totalTime3 / 10000) + " ns/run");

        System.out.println();
    }

    // ==================== Helper Methods ====================

    private static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random(42); // Fixed seed for reproducibility
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    private static int[] generateEndTimes(int[] startTimes) {
        Random rand = new Random(42);
        int[] endTimes = new int[startTimes.length];
        for (int i = 0; i < startTimes.length; i++) {
            endTimes[i] = startTimes[i] + rand.nextInt(50) + 1;
        }
        return endTimes;
    }
}
