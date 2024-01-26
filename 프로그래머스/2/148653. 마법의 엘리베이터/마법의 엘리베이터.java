import java.util.*;

class Solution {
    private static boolean[] visited;
    
    private class Point {
        int number, count;
        
        Point(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    private int bfs(int storey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{storey, 0});
        
        int answer = 10000000;;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollNumber = poll[0];
            int count = poll[1];
            
            if (pollNumber == 0) {
                if (answer > count) {
                    answer = count;
                }
                continue;
            }
            
            int num = pollNumber % 10;
            if (num > 5) { 
                queue.offer(new int[]{pollNumber / 10 + 1, count + 10 - num});
            } else if(num == 5) {
                queue.offer(new int[]{pollNumber / 10, count + num});
                queue.offer(new int[]{pollNumber / 10 + 1, count + 10 - num});
            } else {
                queue.offer(new int[]{pollNumber / 10, count + num});             
            }
        }
        
        return answer;   
    }
    
    public int solution(int storey) {
        int answer = 0;
        visited = new boolean[100000001];
        answer = bfs(storey);
        return answer;
    }
}