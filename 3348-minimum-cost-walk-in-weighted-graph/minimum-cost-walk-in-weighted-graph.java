import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Step 1: Build graph as adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Step 2: Find connected components & store min AND cost per component
        int[] component = new int[n]; // Stores which component a node belongs to
        Arrays.fill(component, -1);
        int[] minCost = new int[n]; // Stores min AND value for each component
        int compId = 0; // Unique component ID
        
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                minCost[compId] = bfs(graph, component, i, compId);
                compId++;
            }
        }

        // Step 3: Answer queries
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            if (component[s] == component[t]) {
                result[i] = minCost[component[s]];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    // BFS to find connected components and compute min AND cost
    private int bfs(Map<Integer, List<int[]>> graph, int[] component, int start, int compId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        component[start] = compId;
        int minAnd = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                minAnd &= weight; // Track minimum AND value
                
                if (component[next] == -1) { // Not visited yet
                    component[next] = compId;
                    queue.add(next);
                }
            }
        }

        return minAnd;
    }
}
