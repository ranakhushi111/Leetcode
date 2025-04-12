class Solution {
    public long countGoodIntegers(int n, int k) {
            long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        Set<String> seen = new HashSet<>();
        long result = 0;
        int halfLength = (n + 1) / 2;
        int start = (int) Math.pow(10, halfLength - 1);
        int end = (int) Math.pow(10, halfLength);

        for (int i = start; i < end; i++) {
            String firstHalf = String.valueOf(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, n / 2)).reverse().toString();
            String palindrome = firstHalf + secondHalf;

            if (Long.parseLong(palindrome) % k != 0) continue;

            char[] digits = palindrome.toCharArray();
            Arrays.sort(digits);
            String key = new String(digits);
            if (seen.contains(key)) continue;
            seen.add(key);

            int[] count = new int[10];
            for (char c : digits) {
                count[c - '0']++;
            }

            if (count[0] == n) continue; // All digits are zero, invalid

            long permutations = 0;
            for (int d = 1; d <= 9; d++) {
                if (count[d] == 0) continue;
                count[d]--;
                long perm = factorial[n - 1];
                for (int cnt : count) {
                    perm /= factorial[cnt];
                }
                permutations += perm;
                count[d]++;
            }

            result += permutations;
        }

        return result; 
    }
}