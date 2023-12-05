import java.util.*;

class Solution {
    static long length;
    static long[] arr = new long[2001];

    public long solution(int n) {
        length = n;
        bfs(); 
        return arr[n];
    }
    
    public void bfs() {
        LinkedList<Long> queue = new LinkedList<>();
        queue.offer(0L);
        
        while (!queue.isEmpty()) {
            long poll = queue.poll();
            
            for (long i = 1; i <= 2; i++) {
                if (poll + i <= length) {
                    queue.offer(poll + i);
                    arr[(int)(poll + i)] = (arr[(int)(poll + i)] + 1) % 1234567;
                }
            }
        }     
    }
}