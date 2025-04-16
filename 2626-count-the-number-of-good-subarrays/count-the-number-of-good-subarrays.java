class Solution {
    public long countGood(int[] nums, int k) {
     Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        long pairCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);

            // Adding val increases pair count by how many already exist
            pairCount += count;
            freq.put(val, count + 1);

            // Shrink window from left until pairCount < k
            while (pairCount >= k) {
                // All subarrays from left to right are good
                result += (nums.length - right);

                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                pairCount -= (leftCount - 1);
                freq.put(leftVal, leftCount - 1);
                left++;
            }
        }

        return result;
   
    }
}