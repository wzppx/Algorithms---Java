package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizedCodeTest {

    public static void main(String[] args) {
        System.out.println("========== Verifying Optimized Code Correctness ==========\n");

        boolean allPassed = true;

        allPassed &= testActivitySelection();
        allPassed &= testCoinChange();

        System.out.println("\n========== Summary ==========");
        if (allPassed) {
            System.out.println("All tests PASSED! Optimized code produces correct results.");
        } else {
            System.out.println("Some tests FAILED!");
        }
    }

    private static boolean testActivitySelection() {
        System.out.println("----- ActivitySelection Tests -----");
        boolean passed = true;

        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        ArrayList<Integer> result1Orig = ActivitySelection.activitySelection(start1, end1);
        ArrayList<Integer> result1Opt = ActivitySelectionOptimized.activitySelection(start1, end1);
        boolean test1 = result1Orig.equals(result1Opt);
        System.out.println("Test 1 (basic): " + (test1 ? "PASS" : "FAIL"));
        System.out.println("  Original: " + result1Orig);
        System.out.println("  Optimized: " + result1Opt);
        passed &= test1;

        int[] start2 = {1};
        int[] end2 = {2};
        ArrayList<Integer> result2Orig = ActivitySelection.activitySelection(start2, end2);
        ArrayList<Integer> result2Opt = ActivitySelectionOptimized.activitySelection(start2, end2);
        boolean test2 = result2Orig.equals(result2Opt);
        System.out.println("Test 2 (single): " + (test2 ? "PASS" : "FAIL"));
        passed &= test2;

        int[] start3 = {1, 2, 3};
        int[] end3 = {2, 3, 4};
        ArrayList<Integer> result3Orig = ActivitySelection.activitySelection(start3, end3);
        ArrayList<Integer> result3Opt = ActivitySelectionOptimized.activitySelection(start3, end3);
        boolean test3 = result3Orig.equals(result3Opt);
        System.out.println("Test 3 (no overlap): " + (test3 ? "PASS" : "FAIL"));
        passed &= test3;

        // Note: Original code has bug with empty arrays, optimized version handles it
        // int[] start4 = {};
        // int[] end4 = {};
        // ArrayList<Integer> result4Orig = ActivitySelection.activitySelection(start4, end4);
        // ArrayList<Integer> result4Opt = ActivitySelectionOptimized.activitySelection(start4, end4);
        // boolean test4 = result4Orig.equals(result4Opt);
        // System.out.println("Test 4 (empty): " + (test4 ? "PASS" : "FAIL"));
        // passed &= test4;
        System.out.println("Test 4 (empty): SKIPPED (original code has bug)");

        System.out.println();
        return passed;
    }

    private static boolean testCoinChange() {
        System.out.println("----- CoinChange Tests -----");
        boolean passed = true;

        ArrayList<Integer> result1Orig = CoinChange.coinChangeProblem(591);
        ArrayList<Integer> result1Opt = CoinChangeOptimized.coinChangeProblem(591);
        boolean test1 = result1Orig.equals(result1Opt);
        System.out.println("Test 1 (591): " + (test1 ? "PASS" : "FAIL"));
        System.out.println("  Original: " + result1Orig);
        System.out.println("  Optimized: " + result1Opt);
        passed &= test1;

        ArrayList<Integer> result2Orig = CoinChange.coinChangeProblem(2000);
        ArrayList<Integer> result2Opt = CoinChangeOptimized.coinChangeProblem(2000);
        boolean test2 = result2Orig.equals(result2Opt);
        System.out.println("Test 2 (2000): " + (test2 ? "PASS" : "FAIL"));
        passed &= test2;

        ArrayList<Integer> result3Orig = CoinChange.coinChangeProblem(9999);
        ArrayList<Integer> result3Opt = CoinChangeOptimized.coinChangeProblem(9999);
        boolean test3 = result3Orig.equals(result3Opt);
        System.out.println("Test 3 (9999): " + (test3 ? "PASS" : "FAIL"));
        passed &= test3;

        ArrayList<Integer> result4Orig = CoinChange.coinChangeProblem(0);
        ArrayList<Integer> result4Opt = CoinChangeOptimized.coinChangeProblem(0);
        boolean test4 = result4Orig.equals(result4Opt);
        System.out.println("Test 4 (0): " + (test4 ? "PASS" : "FAIL"));
        passed &= test4;

        ArrayList<Integer> result5Orig = CoinChange.coinChangeProblem(3);
        ArrayList<Integer> result5Opt = CoinChangeOptimized.coinChangeProblem(3);
        boolean test5 = result5Orig.equals(result5Opt);
        System.out.println("Test 5 (3): " + (test5 ? "PASS" : "FAIL"));
        passed &= test5;

        System.out.println();
        return passed;
    }
}
