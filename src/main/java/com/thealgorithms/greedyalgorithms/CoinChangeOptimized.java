package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;

public final class CoinChangeOptimized {

    private static final int[] COINS = {2000, 500, 100, 50, 20, 10, 5, 2, 1};

    private CoinChangeOptimized() {
    }

    public static ArrayList<Integer> coinChangeProblem(int amount) {
        ArrayList<Integer> ans = new ArrayList<>(estimateSize(amount));

        for (int coin : COINS) {
            if (amount >= coin) {
                int count = amount / coin;
                for (int j = 0; j < count; j++) {
                    ans.add(coin);
                }
                amount %= coin;
            }
            if (amount == 0) {
                break;
            }
        }

        return ans;
    }

    private static int estimateSize(int amount) {
        if (amount <= 0) {
            return 0;
        }
        return amount / 100 + 10;
    }
}
