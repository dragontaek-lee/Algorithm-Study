import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2606 {
    static ArrayList<Integer>[] graph;
    static Boolean[] visited;
    static int count = 0;

    public static void dfs(int n) {
        visited[n] = true;
        ++count;

        for(int i: graph[n]) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new Boolean[n+1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }


        for(int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i < n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(1);

        System.out.println(count-1);
    }
}
