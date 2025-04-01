class Solution {
    public long mostPoints(int[][] questions) {
         int n = questions.length;
        long[] dp = new long[n + 1]; // dp[i] stores the max points we can get starting from index i
        
        for (int i = n - 1; i >= 0; i--) { // Traverse the questions array in reverse
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextQuestion = i + brainpower + 1; // The next question that can be attempted after solving i
            
            // Option 1: Solve this question
            long solve = points + (nextQuestion < n ? dp[nextQuestion] : 0);
            
            // Option 2: Skip this question
            long skip = dp[i + 1];
            
            // Take the maximum of solving or skipping
            dp[i] = Math.max(solve, skip);
        }
        
        return dp[0]; // The maximum points obtainable starting from question 0
    }
    }
