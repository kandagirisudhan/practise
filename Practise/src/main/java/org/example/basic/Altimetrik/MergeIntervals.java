package org.example.basic.Altimetrik;
//based on this interval when its overlap
//need to merge the starting starti+endingi
//Input : [[1,3,][2,6],[8,9],[15,13]]
//Output : [[1,6][8,9],[15,13]]
//overlap elements [[1,3,][2,6]]
//https://www.geeksforgeeks.org/merging-intervals/ geek for geeks

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeIntervals {

    public static void main(String[] args) {
        // Input intervals
        int[][] intervals = {{1, 3}, {2, 6}, {8, 9}, {15, 13}};

        // Solve the problem
        int[][] mergedIntervals = merge(intervals);

        // Output the result
        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // Handle case where there are no intervals
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Initialize with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Iterate through the intervals
        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check if there is an overlap between the current and next intervals
            if (nextStart <= currentEnd) {
                // Merge the intervals by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, so move to the next interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the list of merged intervals to a 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }
}
