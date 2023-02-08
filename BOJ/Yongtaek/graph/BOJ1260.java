import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;

public class BOJ1260 {
    static ArrayList<Integer>[] graph;
    static Boolean[] visited1;
    static Boolean[] visited2;
    static LinkedList<Integer> queue = new LinkedList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void dfs(int r) {
        visited1[r] = true;
        sb1.append(r + " ");

        for(int i: graph[r]) {
            if(visited1[i]) continue;

            visited1[i] = true;
            dfs(i);
        }
    }

    public static void bfs(int r) {
        queue.offer(r);
        visited2[r] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
               
            sb2.append(n + " ");

            for(int i: graph[n]) {
                if(visited2[i]) continue;

                queue.offer(i);
                visited2[i] = true;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited1 = new Boolean[n+1];
        visited2 = new Boolean[n+1];

        for(int i = 1; i < n + 1; i++) {
            visited1[i] = false;
        }

        for(int i = 1; i < n + 1; i++) {
            visited2[i] = false;
        }

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        bfs(v);

        System.out.println(sb1);
        System.out.println(sb2);
        
    }
}
