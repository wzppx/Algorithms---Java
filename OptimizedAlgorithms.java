import java.util.*;

public final class OptimizedAlgorithms {
    private OptimizedAlgorithms() {}
    
    public static final class ActivitySelectionOptimized {
        private ActivitySelectionOptimized() {}
        
        public static ArrayList<Integer> activitySelection(int[] startTimes, int[] endTimes) {
            int n = startTimes.length;
            if (n == 0) {
                return new ArrayList<Integer>();
            }
            
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            
            Arrays.sort(indices, new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return Integer.compare(endTimes[i1], endTimes[i2]);
                }
            });
            
            ArrayList<Integer> selectedActivities = new ArrayList<Integer>();
            int lastIndex = indices[0];
            selectedActivities.add(lastIndex);
            int lastEndTime = endTimes[lastIndex];
            
            for (int i = 1; i < n; i++) {
                int currentIndex = indices[i];
                if (startTimes[currentIndex] >= lastEndTime) {
                    selectedActivities.add(currentIndex);
                    lastEndTime = endTimes[currentIndex];
                }
            }
            
            return selectedActivities;
        }
    }
    
    public static final class CoinChangeOptimized {
        private CoinChangeOptimized() {}
        
        private static final int[] COINS_DESC = {2000, 500, 100, 50, 20, 10, 5, 2, 1};
        
        public static ArrayList<Integer> coinChangeProblem(int amount) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            
            for (int i = 0; i < COINS_DESC.length && amount > 0; i++) {
                int coin = COINS_DESC[i];
                if (coin <= amount) {
                    int count = amount / coin;
                    amount = amount % coin;
                    for (int j = 0; j < count; j++) {
                        ans.add(coin);
                    }
                }
            }
            return ans;
        }
    }
}
