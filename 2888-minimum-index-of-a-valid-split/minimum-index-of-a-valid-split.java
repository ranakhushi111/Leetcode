import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int candidate = nums.get(0), count = 0;
        
        // Finding the majority candidate using Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = num;
                    count = 1;
                }
            }
        }

        // Counting occurrences of the candidate in the entire array
        int totalOccurrences = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalOccurrences++;
            }
        }

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int rightCount = totalOccurrences - leftCount;
            int leftSize = i + 1, rightSize = n - leftSize;

            // Checking if both halves satisfy the dominance condition
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1; // If no valid index is found
    }
}

    
