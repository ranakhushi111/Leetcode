import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Sort the ranks to improve efficiency
        Arrays.sort(ranks);
        
        // Binary search range: min time = 1, max time = (min_rank * cars^2)
        long left = 1, right = (long) ranks[0] * (long) cars * (long) cars;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                right = mid;  // Try a smaller time
            } else {
                left = mid + 1;  // Increase time
            }
        }
        
        return left; // Minimum time required
    }

    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += (long) Math.sqrt(time / rank);
            if (totalCars >= cars) return true; // Early exit for efficiency
        }
        return false;
    }
}


   
        
    
