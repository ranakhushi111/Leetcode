class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
       long minPrefix = 0, maxPrefix = 0, currentSum = 0;

        for (int diff : differences) {
            currentSum += diff;
            minPrefix = Math.min(minPrefix, currentSum);
            maxPrefix = Math.max(maxPrefix, currentSum);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int) Math.max(0, maxStart - minStart + 1);  
    }
}