import java.io.*;
import java.util.*;

public class BOJ1753_2 {
    static ArrayList<Pair>[] graph;
    static int[] distance;

    public static class Pair implements Comparable<Pair> {
        int v,w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.w == p.w) return this.v - p.v;
            return this.w - p.w;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();
        distance[start] = 0;
        pQueue.offer(new Pair(start, 0));

        while (!pQueue.isEmpty()) {
            Pair pollPair = pQueue.poll();
            int pollV = pollPair.v;
            int pollW = pollPair.w;

            if(distance[pollV] < pollW) {
                continue;
            }
            
            for(Pair p: graph[pollV]) {
                int cost = p.w + pollW;
                if(cost < distance[p.v]) {
                    distance[p.v] = cost;
                    pQueue.offer(new Pair(p.v, cost));
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        distance = new int[V+1];

        for (int i = 1; i < V+1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V+1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }   
}
