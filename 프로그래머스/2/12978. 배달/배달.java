import java.util.*;

class Solution {
    static ArrayList<Pair>[] graph;
    static int[] distance;
    
    private class Pair implements Comparable<Pair>{
        int v,w;
        
        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Pair p) {
            if (this.w == p.w) {
                return this.v - p.v;
            }
            
            return this.w - p.w;
        }
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.offer(new Pair(start, 0));
        
        distance[start] = 0;
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            
            int pollV = pair.v;
            int pollW = pair.w;
            
            if (distance[pollV] < pollW) {
                continue;
            }
            
            for (Pair p: graph[pollV]) {
                int cost = pollW + p.w;
                if (cost < distance[p.v]) {
                    distance[p.v] = cost;
                    pq.offer(new Pair(p.v ,cost));
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        distance = new int[N+1];
        graph = new ArrayList[N+1];
        
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            
            graph[start].add(new Pair(end, weight));
            graph[end].add(new Pair(start, weight));
        }

        dijkstra(1);
        
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}