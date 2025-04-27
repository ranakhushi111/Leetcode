class Solution {
    public int countSubarrays(int[] nums) {
       int count = 0;
        
        // Traverse the array and check every subarray of length 3
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            
            // Check if second is divisible by 2
            if (second % 2 == 0 && first + third == second / 2) {
                count++;
            }
        }
        
        return count;  
    }
}