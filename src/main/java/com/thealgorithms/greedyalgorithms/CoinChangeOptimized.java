package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;

public final class CoinChangeOptimized {

    private CoinChangeOptimized() {
    }

    // Predefined coin denominations (descending order) - avoid sorting on each call
    private static final int[] COINS = {2000, 500, 100, 50, 20, 10, 5, 2, 1};

    /**
     * Optimized coin change algorithm
     *
     * Optimizations:
     * 1. Use static final array for coin denominations to avoid sorting on each call
     * 2. Use division and modulo instead of loop subtraction to reduce iterations
     * 3. Pre-allocate ArrayList capacity to avoid resizing overhead
     * 4. Use primitive int array instead of Integer array to avoid boxing
     *
     * @param amount Amount to make change for
     * @return List of coins
     */
    public static ArrayList<Integer> coinChangeProblem(int amount) {
        ArrayList<Integer> ans = new ArrayList<>(16); // Pre-allocate reasonable capacity

        // Use division to calculate coin count instead of loop subtraction
        for (int coin : COINS) {
            if (amount >= coin) {
                int count = amount / coin;  // Calculate how many coins of this denomination
                for (int i = 0; i < count; i++) {
                    ans.add(coin);
                }
                amount %= coin;  // Update remaining amount
            }
        }

        return ans;
    }
}
