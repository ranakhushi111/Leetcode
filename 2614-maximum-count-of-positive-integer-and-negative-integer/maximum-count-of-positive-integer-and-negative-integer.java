import java.util.*;

class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstZeroOrPositive(nums); // Count of negative numbers
        int posCount = nums.length - findFirstPositive(nums); // Count of positive numbers
        return Math.max(negCount, posCount);
    }

    // Binary search to find the first index of 0 or positive number
    private int findFirstZeroOrPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // Binary search to find the first index of a positive number
    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumCount(new int[]{-2, -1, -1, 1, 2, 3})); // Output: 3
        System.out.println(sol.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2})); // Output: 3
        System.out.println(sol.maximumCount(new int[]{5, 20, 66, 1314})); // Output: 4
    }
}
