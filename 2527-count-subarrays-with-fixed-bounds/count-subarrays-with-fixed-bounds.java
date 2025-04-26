class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
      int n = nums.length;
        long count = 0;
        
        int minPos = -1; // latest index of minK
        int maxPos = -1; // latest index of maxK
        int badPos = -1; // latest index where nums[i] is out of bounds
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            // If number is out of [minK, maxK] bounds
            if (num < minK || num > maxK) {
                badPos = i;
            }
            
            // Update minPos and maxPos
            if (num == minK) {
                minPos = i;
            }
            if (num == maxK) {
                maxPos = i;
            }
            
            // Number of valid subarrays ending at i
            int minValid = Math.min(minPos, maxPos);
            if (minValid > badPos) {
                count += (minValid - badPos);
            }
        }
        
        return count;   
    }
}