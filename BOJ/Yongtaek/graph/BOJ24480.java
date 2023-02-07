import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ24480 {
    static Boolean visited[];
    static ArrayList<Integer>[] edge;
    static int answer[];
    static int index = 0;

    public static void dfs(int r) {
        visited[r] = true;
        answer[r] = ++index;

        for(int i : edge[r]) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i);
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

        edge = new ArrayList[n+1];
        visited = new Boolean[n+1];
        answer = new int[n+1];

        for(int i = 1; i < n + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
         
            edge[u].add(v);
            edge[v].add(u);
        }

        for(int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }

        for(int i = 1; i < n + 1; i++) {
            Collections.sort(edge[i],Collections.reverseOrder());
        }

        dfs(r);

        for(int i = 1; i < n + 1; i++) {
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    } 

}
