import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];
        
        // Sorting queries and storing their original indices
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));

        // Min-Heap to process cells in increasing order
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0}); // {Value, Row, Col}

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        // BFS Variables
        int count = 0;
        int queryIndex = 0;
        int[] directions = {-1, 0, 1, 0, -1}; // For moving in 4 directions
        
        while (queryIndex < k) {
            int currentQuery = queryWithIndex[queryIndex][0];
            int originalIndex = queryWithIndex[queryIndex][1];

            // Process all cells whose value is smaller than currentQuery
            while (!minHeap.isEmpty() && minHeap.peek()[0] < currentQuery) {
                int[] cell = minHeap.poll();
                int val = cell[0], r = cell[1], c = cell[2];
                count++; // Increase the number of points collected

                // Expand in 4 directions
                for (int d = 0; d < 4; d++) {
                    int nr = r + directions[d], nc = c + directions[d + 1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            
            // Store the result for this query
            answer[originalIndex] = count;
            queryIndex++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {1, 2, 4},
            {3, 4, 3},
            {2, 1, 5}
        };
        int[] queries = {2, 3, 6};
        int[] result = sol.maxPoints(grid, queries);
        
        // Print the result
        System.out.println(Arrays.toString(result));
    }
}


