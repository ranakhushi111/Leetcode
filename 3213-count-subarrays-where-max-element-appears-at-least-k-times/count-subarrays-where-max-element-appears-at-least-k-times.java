class Solution {
    public long countSubarrays(int[] nums, int k) {
       int n = nums.length;

        // Find the max value in the entire array
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long result = 0;
        int count = 0; // Count of max elements in current window
        int left = 0;

        // Sliding window from left to right
        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                count++;
            }

            // Move left until count of max is >= k
            while (count >= k) {
                // Every subarray starting at `left` and ending at or after `right` is valid
                result += n - right;

                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
        }

        return result;  
    }
}