import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24444 {
    static ArrayList<Integer>[] graph;
    static Boolean[] visited;
    static LinkedList<Integer> queue;
    static int[] answer;
    static int index = 0;

    public static void bfs(int r) {
        queue.offer(r);
        visited[r] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();

            answer[n] = ++index;

            for(int i : graph[n]) {
                if(visited[i]) continue;

                queue.offer(i);
                visited[i] = true;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new Boolean[n+1];
        answer = new int[n+1];
        queue = new LinkedList<>();

        for(int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }

        for(int i = 1; i < n + 1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        bfs(r);

        for(int i = 1; i < n + 1; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }
}
