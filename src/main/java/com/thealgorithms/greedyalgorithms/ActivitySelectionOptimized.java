package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public final class ActivitySelectionOptimized {

    private ActivitySelectionOptimized() {
    }

    public static ArrayList<Integer> activitySelection(int[] startTimes, int[] endTimes) {
        int n = startTimes.length;
        
        if (n == 0) {
            return new ArrayList<>();
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(i -> endTimes[i]));

        ArrayList<Integer> selectedActivities = new ArrayList<>(n);
        
        selectedActivities.add(indices[0]);
        int lastEndTime = endTimes[indices[0]];

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
