class Solution {
    int max = 0;
    private void dfs(int[][] dungeons, int fatigue, int depth, boolean[] visited) {
        if (depth > max) {
            max = depth;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || fatigue < dungeons[i][0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(dungeons, fatigue - dungeons[i][1], depth + 1, visited);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(dungeons, k, 0, visited);
        
        return max;
    }
}