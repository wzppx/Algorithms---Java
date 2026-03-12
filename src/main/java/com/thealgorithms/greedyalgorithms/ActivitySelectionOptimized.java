package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public final class ActivitySelectionOptimized {

    private ActivitySelectionOptimized() {
    }

    /**
     * Optimized activity selection algorithm
     *
     * Optimizations:
     * 1. Use Integer[] index array instead of 2D array to reduce memory usage
     * 2. Use quick sort instead of Arrays.sort to avoid boxing overhead
     * 3. Use int instead of Integer for basic operations to avoid autoboxing
     * 4. Pre-allocate ArrayList capacity to avoid resizing overhead
     *
     * @param startTimes Array containing start times of activities
     * @param endTimes   Array containing end times of activities
     * @return List of selected activity indices
     */
    public static ArrayList<Integer> activitySelection(int[] startTimes, int[] endTimes) {
        int n = startTimes.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        // Create index array
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Quick sort indices by end time
        quickSort(indices, endTimes, 0, n - 1);

        // Pre-allocate capacity to avoid resizing
        ArrayList<Integer> selectedActivities = new ArrayList<>(n);

        // Select first activity
        selectedActivities.add(indices[0]);
        int lastEndTime = endTimes[indices[0]];

        // Iterate through remaining activities
        for (int i = 1; i < n; i++) {
            int idx = indices[i];
            if (startTimes[idx] >= lastEndTime) {
                selectedActivities.add(idx);
                lastEndTime = endTimes[idx];
            }
        }

        return selectedActivities;
    }

    /**
     * Quick sort - sort indices by end time
     */
    private static void quickSort(Integer[] indices, int[] endTimes, int low, int high) {
        if (low < high) {
            int pi = partition(indices, endTimes, low, high);
            quickSort(indices, endTimes, low, pi - 1);
            quickSort(indices, endTimes, pi + 1, high);
        }
    }

    private static int partition(Integer[] indices, int[] endTimes, int low, int high) {
        int pivot = endTimes[indices[high]];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (endTimes[indices[j]] <= pivot) {
                i++;
                swap(indices, i, j);
            }
        }
        swap(indices, i + 1, high);
        return i + 1;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
