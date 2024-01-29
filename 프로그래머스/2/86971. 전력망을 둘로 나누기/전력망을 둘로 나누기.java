import java.util.*;

class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] edges;
    private static int tempCount = 1;
    
    private void initWires(int n, int targetIndex, int[][] wires) {
        visited = new boolean[n+1];
        edges = new ArrayList[n+1];
        
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            if (i == targetIndex) {
                continue;
            }
            edges[wires[i][0]].add(wires[i][1]);
            edges[wires[i][1]].add(wires[i][0]);
        }
    }
    
    private void dfs(int n) {
        visited[n] = true;
        
        for (int i : edges[n]) {
            if (!visited[i]) {
                dfs(i);
                tempCount++;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            initWires(n, i, wires);
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                    if (count == 0) {
                        count += tempCount;
                    } else {
                        count -= tempCount;
                    }
                    tempCount = 1;
                }
            }
            answer = Math.min(answer, Math.abs(count));
        }
        
        return answer;
    }
}