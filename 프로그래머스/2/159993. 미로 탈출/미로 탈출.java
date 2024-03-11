import java.util.*;

class Solution {
    static String[][] graph;
    static boolean[][] visited;
    static int[] start = new int[2];
    static int[] lever = new int[2];
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    
    private class Point {
        int x,y,depth;
        
        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    private void initGraph(String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char target = maps[i].charAt(j);
                           
                if (target == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                
                if (target == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
                
                graph[i][j] = String.valueOf(target);
            }
        }
    }
    
    private int bfs(int startX, int startY, String target) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[graph.length][graph[0].length];
        queue.offer(new Point(startX, startY, 0));
        
        int depth = 0;
        
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int pollx = poll.x;
            int polly = poll.y;
            int pollDepth = poll.depth;
            
            if (graph[pollx][polly].equals(target)) {
                depth = pollDepth;
                return depth;
            }
            
            visited[pollx][polly] = true;
            
            for (int i = 0; i < 4; i++) {
                int movedX = pollx + moveX[i];
                int movedY = polly + moveY[i];
                
                if (movedX < 0 || movedY < 0 || movedX >= graph.length || movedY >= graph[0].length) {
                    continue;
                }
                
                if (visited[movedX][movedY] || graph[movedX][movedY].equals("X")) {
                    continue;
                }
                
                visited[movedX][movedY] = true;
                queue.offer(new Point(movedX, movedY, pollDepth + 1));
            } 
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        graph = new String[maps.length][maps[0].length()];
        
        initGraph(maps);
        
        System.out.println(start[0] + " "+ start[1]);
        
        int toLeverWeight = bfs(start[0], start[1], "L");
        int toExitWeight = bfs(lever[0], lever[1], "E");
        
        if (toLeverWeight == -1 || toExitWeight == -1) {
            return -1;
        }

        return toLeverWeight + toExitWeight;
    }
}