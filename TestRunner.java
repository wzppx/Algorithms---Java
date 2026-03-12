import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== Running Original Code Tests with Performance ===");
        System.out.println();
        
        runActivitySelectionTests();
        System.out.println();
        runCoinChangeTests();
    }
    
    private static void runActivitySelectionTests() {
        System.out.println("--- ActivitySelection Tests ---");
        
        int[][] testStarts = {
            {1, 3, 0, 5, 8, 5},
            {1},
            {1, 2, 3}
        };
        int[][] testEnds = {
            {2, 4, 6, 7, 9, 9},
            {2},
            {2, 3, 4}
        };
        List<List<Integer>> expectedResults = Arrays.asList(
            Arrays.asList(0, 1, 3, 4),
            Collections.singletonList(0),
            Arrays.asList(0, 1, 2)
        );
        String[] testNames = {"Basic test", "Single activity", "No overlap"};
        
        for (int i = 0; i < testStarts.length; i++) {
            int[] start = testStarts[i];
            int[] end = testEnds[i];
            List<Integer> expected = expectedResults.get(i);
            
            long totalTime = 0;
            int iterations = 1000000;
            ArrayList<Integer> result = null;
            
            for (int j = 0; j < iterations; j++) {
                long startTime = System.nanoTime();
                result = ActivitySelectionOriginal.activitySelection(start, end);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            
            boolean passed = expected.equals(result);
            double avgTime = totalTime / (double) iterations;
            System.out.println(testNames[i] + ": " + (passed ? "PASS" : "FAIL") + 
                " | Avg time: " + String.format("%.2f", avgTime) + " ns");
        }
    }
    
    private static void runCoinChangeTests() {
        System.out.println("--- CoinChange Tests ---");
        
        int[] testAmounts = {591, 2000, 570, 3, 9999, 2888, 0};
        List<List<Integer>> expectedResults = Arrays.asList(
            Arrays.asList(500, 50, 20, 20, 1),
            Collections.singletonList(2000),
            Arrays.asList(500, 50, 20),
            Arrays.asList(2, 1),
            Arrays.asList(2000, 2000, 2000, 2000, 500, 500, 500, 100, 100, 100, 100, 50, 20, 20, 5, 2, 2),
            Arrays.asList(2000, 500, 100, 100, 100, 50, 20, 10, 5, 2, 1),
            Collections.<Integer>emptyList()
        );
        String[] testNames = {"591", "2000", "570", "3", "9999", "2888", "0"};
        
        for (int i = 0; i < testAmounts.length; i++) {
            int amount = testAmounts[i];
            List<Integer> expected = expectedResults.get(i);
            
            long totalTime = 0;
            int iterations = 1000000;
            ArrayList<Integer> result = null;
            
            for (int j = 0; j < iterations; j++) {
                long startTime = System.nanoTime();
                result = CoinChangeOriginal.coinChangeProblem(amount);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            
            boolean passed = expected.equals(result);
            double avgTime = totalTime / (double) iterations;
            System.out.println("Amount " + testNames[i] + ": " + (passed ? "PASS" : "FAIL") + 
                " | Avg time: " + String.format("%.2f", avgTime) + " ns");
        }
    }
}

class ActivitySelectionOriginal {
    public static ArrayList<Integer> activitySelection(int[] startTimes, int[] endTimes) {
        int n = startTimes.length;
        int[][] activities = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            activities[i][0] = i;
            activities[i][1] = startTimes[i];
            activities[i][2] = endTimes[i];
        }
        
        Arrays.sort(activities, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[2], a2[2]);
            }
        });
        
        int lastEndTime;
        ArrayList<Integer> selectedActivities = new ArrayList<Integer>();
        
        selectedActivities.add(activities[0][0]);
        lastEndTime = activities[0][2];
        
        for (int i = 1; i < n; i++) {
            if (activities[i][1] >= lastEndTime) {
                selectedActivities.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }
        
        return selectedActivities;
    }
}

class CoinChangeOriginal {
    public static ArrayList<Integer> coinChangeProblem(int amount) {
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(coins, Collections.reverseOrder());
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        return ans;
    }
}
