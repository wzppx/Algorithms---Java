package com.thealgorithms.greedyalgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PerformanceTestOptimized {

    private long testActivitySelection(int[] start, int[] end, ArrayList<Integer> expected) {
        long startTime = System.nanoTime();
        ArrayList<Integer> result = ActivitySelectionOptimized.activitySelection(start, end);
        long endTime = System.nanoTime();
        assertEquals(expected, result);
        return endTime - startTime;
    }

    private long testCoinChange(int amount, ArrayList<Integer> expected) {
        long startTime = System.nanoTime();
        ArrayList<Integer> result = CoinChangeOptimized.coinChangeProblem(amount);
        long endTime = System.nanoTime();
        assertEquals(expected, result);
        return endTime - startTime;
    }

    @Test
    public void testActivitySelectionPerformance() {
        System.out.println("\n========== ActivitySelection 优化后性能测试 ==========");
        
        long total = 0;
        
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        long time1 = testActivitySelection(start1, end1, new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        System.out.println("testActivitySelection: " + time1 + " ns");
        total += time1;

        int[] start2 = {1};
        int[] end2 = {2};
        long time2 = testActivitySelection(start2, end2, new ArrayList<>(List.of(0)));
        System.out.println("testSingleActivity: " + time2 + " ns");
        total += time2;

        int[] start3 = {1, 2, 3};
        int[] end3 = {2, 3, 4};
        long time3 = testActivitySelection(start3, end3, new ArrayList<>(Arrays.asList(0, 1, 2)));
        System.out.println("testNoOverlap: " + time3 + " ns");
        total += time3;

        System.out.println("ActivitySelection 优化后总耗时: " + total + " ns");
        System.out.println("ActivitySelection 优化后平均耗时: " + (total / 3) + " ns");
    }

    @Test
    public void testCoinChangePerformance() {
        System.out.println("\n========== CoinChange 优化后性能测试 ==========");
        
        long total = 0;

        long time1 = testCoinChange(591, new ArrayList<>(Arrays.asList(500, 50, 20, 20, 1)));
        System.out.println("testCoinChangeProblemWithValidAmount: " + time1 + " ns");
        total += time1;

        long time2 = testCoinChange(2000, new ArrayList<>(List.of(2000)));
        System.out.println("testCoinChangeProblemWithLargeAmount: " + time2 + " ns");
        total += time2;

        long time3 = testCoinChange(570, new ArrayList<>(Arrays.asList(500, 50, 20)));
        System.out.println("testCoinChangeProblemWithPartialCoins2: " + time3 + " ns");
        total += time3;

        long time4 = testCoinChange(3, new ArrayList<>(Arrays.asList(2, 1)));
        System.out.println("testCoinChangeProblemWithSmallAmount: " + time4 + " ns");
        total += time4;

        long time5 = testCoinChange(9999, new ArrayList<>(Arrays.asList(2000, 2000, 2000, 2000, 500, 500, 500, 100, 100, 100, 100, 50, 20, 20, 5, 2, 2)));
        System.out.println("testCoinChangeProblemWithLargeAmountAndMultipleDenominations: " + time5 + " ns");
        total += time5;

        long time6 = testCoinChange(2888, new ArrayList<>(Arrays.asList(2000, 500, 100, 100, 100, 50, 20, 10, 5, 2, 1)));
        System.out.println("testCoinChangeProblemWithAllDenominations: " + time6 + " ns");
        total += time6;

        long time7 = testCoinChange(0, new ArrayList<>());
        System.out.println("testCoinChangeProblemWithZeroAmount: " + time7 + " ns");
        total += time7;

        System.out.println("CoinChange 优化后总耗时: " + total + " ns");
        System.out.println("CoinChange 优化后平均耗时: " + (total / 7) + " ns");
    }
}
