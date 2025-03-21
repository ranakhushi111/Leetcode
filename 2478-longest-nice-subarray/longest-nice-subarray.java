import java.util.*;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitMask = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // If adding nums[right] causes an AND conflict, shrink the window
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; // Remove nums[left] from the bitMask
                left++; // Move left pointer
            }

            // Include the new number in the bitMask
            bitMask |= nums[right];

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
