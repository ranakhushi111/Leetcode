class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] count = new int[N + 1];
        int a = -1, b = -1;
        
        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (count[i] == 2) a = i;
            if (count[i] == 0) b = i;
        }
        
        return new int[]{a, b};
    }
    
}