import java.util.*;

public class OptimizedTestRunner {
    public static void main(String[] args) {
        System.out.println("=== Running Optimized Code Tests with Performance ===");
        System.out.println();
        
        runActivitySelectionOptimizedTests();
        System.out.println();
        runCoinChangeOptimizedTests();
    }
    
    private static void runActivitySelectionOptimizedTests() {
        System.out.println("--- ActivitySelection Optimized Tests ---");
        
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
                result = OptimizedAlgorithms.ActivitySelectionOptimized.activitySelection(start, end);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            
            boolean passed = expected.equals(result);
            double avgTime = totalTime / (double) iterations;
            System.out.println(testNames[i] + ": " + (passed ? "PASS" : "FAIL") + 
                " | Avg time: " + String.format("%.2f", avgTime) + " ns");
        }
    }
    
    private static void runCoinChangeOptimizedTests() {
        System.out.println("--- CoinChange Optimized Tests ---");
        
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
                result = OptimizedAlgorithms.CoinChangeOptimized.coinChangeProblem(amount);
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
