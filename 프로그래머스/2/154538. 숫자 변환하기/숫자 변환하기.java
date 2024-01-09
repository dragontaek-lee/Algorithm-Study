import java.util.*;

class ValueDepth {
    int value, depth;
    
    ValueDepth(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}

class Solution {
    public int bfs(int x, int y, int n) {
        boolean[] visited = new boolean[1000001];
        LinkedList<ValueDepth> queue = new LinkedList<>();
        queue.offer(new ValueDepth(x, 0));
        
        int minDepth = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            ValueDepth valueDepth = queue.poll();
            int pollValue = valueDepth.value;
            int pollDepth = valueDepth.depth;
            
            if (pollValue == y && pollDepth < minDepth) {
                minDepth = pollDepth;
            }
            
            if (pollValue + n <= y && !visited[pollValue]) {
                queue.offer(new ValueDepth(pollValue + n, pollDepth + 1));
            }
            
            if (pollValue * 2 <= y && !visited[pollValue]) {
                queue.offer(new ValueDepth(pollValue * 2, pollDepth + 1));
            }
            
            if (pollValue * 3 <= y && !visited[pollValue]) {
                queue.offer(new ValueDepth(pollValue * 3, pollDepth + 1));
            }
            
            visited[pollValue] = true;
        }
        
        return minDepth;
    }
    
    
    public int solution(int x, int y, int n) {
        int answer = bfs(x,y,n);

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        
        return answer;
    }
}