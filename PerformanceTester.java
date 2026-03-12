import com.thealgorithms.greedyalgorithms.ActivitySelection;
import com.thealgorithms.greedyalgorithms.CoinChange;
import java.util.*;

public class PerformanceTester {
    public static void main(String[] args) {
        System.out.println("=== Performance Test Start ===");
        System.out.println();
        
        testActivitySelectionPerformance();
        System.out.println();
        
        testCoinChangePerformance();
        
        System.out.println();
        System.out.println("=== Performance Test End ===");
    }
    
    private static void testActivitySelectionPerformance() {
        System.out.println("--- ActivitySelection Performance ---");
        
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        
        long totalTime = 0;
        int iterations = 1000000;
        
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            ActivitySelection.activitySelection(start, end);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        
        double avgTime = totalTime / (double) iterations;
        System.out.println("Test Case 1 (basic):");
        System.out.println("  Iterations: " + iterations);
        System.out.println("  Total time: " + totalTime + " ns");
        System.out.println("  Avg time: " + String.format("%.2f", avgTime) + " ns");
        
        int[] largeStart = new int[1000];
        int[] largeEnd = new int[1000];
        Random rand = new Random(42);
        for (int i = 0; i < 1000; i++) {
            largeStart[i] = rand.nextInt(10000);
            largeEnd[i] = largeStart[i] + rand.nextInt(100) + 1;
        }
        
        totalTime = 0;
        iterations = 1000;
        
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            ActivitySelection.activitySelection(largeStart, largeEnd);
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        
        avgTime = totalTime / (double) iterations;
        System.out.println("Test Case 2 (1000 activities):");
        System.out.println("  Iterations: " + iterations);
        System.out.println("  Total time: " + totalTime + " ns");
        System.out.println("  Avg time: " + String.format("%.2f", avgTime) + " ns");
    }
    
    private static void testCoinChangePerformance() {
        System.out.println("--- CoinChange Performance ---");
        
        int[] testAmounts = {591, 2000, 570, 3, 9999, 2888, 0};
        String[] testNames = {"591", "2000", "570", "3", "9999", "2888", "0"};
        
        for (int t = 0; t < testAmounts.length; t++) {
            int amount = testAmounts[t];
            long totalTime = 0;
            int iterations = 1000000;
            
            for (int i = 0; i < iterations; i++) {
                long startTime = System.nanoTime();
                CoinChange.coinChangeProblem(amount);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            
            double avgTime = totalTime / (double) iterations;
            System.out.println("Test Case (amount=" + testNames[t] + "):");
            System.out.println("  Iterations: " + iterations);
            System.out.println("  Total time: " + totalTime + " ns");
            System.out.println("  Avg time: " + String.format("%.2f", avgTime) + " ns");
        }
    }
}
