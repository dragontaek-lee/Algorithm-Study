import java.io.*;
import java.util.*;

public class BOJ1504_2 {
    static ArrayList<Pair>[] graph;
    static int[] distance;

    private static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();
        pQueue.offer(new Pair(start, 0));
        distance[start] = 0;

        while(!pQueue.isEmpty()) {
            Pair poll = pQueue.poll();
            int pollb = poll.b;
            int pollc = poll.c;

            if(distance[pollb] < pollc) {
                continue;
            }

            for(Pair p : graph[pollb]) {
                int cost = p.c + pollc;
                if(cost < distance[p.b]) {
                    distance[p.b] = cost;
                    pQueue.offer(new Pair(p.b, cost));
                }
            }
        }
    }

    public static class Pair implements Comparable<Pair> {
        int b,c;

        public Pair(int b, int c) {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.c == p.c) return this.b - this.b;
            return this.c - p.c;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        long firstRoute = distance[v1];

        dijkstra(v1);
        long secondRoute = distance[v2];

        dijkstra(v2);
        long lastRoute = distance[N];

        dijkstra(1);
        long firstRouteAlt = distance[v2];

        dijkstra(v2);
        long secondRouteAlt = distance[v1];

        dijkstra(v1);
        long lastRouteAlt = distance[N];

        long totalFirst = firstRoute + secondRoute + lastRoute;
        long totalSecond = firstRouteAlt + secondRouteAlt + lastRouteAlt;

        long total = Math.min(totalFirst, totalSecond);

        if (total >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(total);
        }
    }
}
