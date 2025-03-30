import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Record the last index of each character
        int[] lastIndex = new int[26]; // Since s contains only lowercase letters
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        // Step 2: Iterate and determine partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            if (i == end) { // If we reach the end of a partition
                result.add(end - start + 1);
                start = i + 1; // Move to the next partition
            }
        }
        
        return result;
    }

    // Driver code to test
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij")); // Output: [9,7,8]
        System.out.println(solution.partitionLabels("eccbbbbdec")); // Output: [10]
    }
}
