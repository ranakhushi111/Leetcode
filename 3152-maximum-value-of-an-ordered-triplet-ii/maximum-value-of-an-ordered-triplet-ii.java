class Solution {
    public long maximumTripletValue(int[] nums) {
          int n = nums.length;
        if (n < 3) return 0L; // Handling cases where triplets cannot be formed
        
        int[] pmax = pfunc(nums);
        int[] smax = sfunc(nums);
        long max = 0L; // Initialize max to 0 instead of Long.MIN_VALUE

        for (int j = 1; j < n - 1; j++) {
            long ans = ((long) pmax[j - 1] - nums[j]) * smax[j + 1]; // Ensure subtraction is long
            max = Math.max(max, ans);
        }
        return max;
    }

    public int[] pfunc(int[] arr) {
        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans[i] = Math.max(arr[i], ans[i - 1]);
        }
        return ans;
    }

    public int[] sfunc(int[] arr) {
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            ans[i] = Math.max(arr[i], ans[i + 1]);
        }
        return ans;
    }
}