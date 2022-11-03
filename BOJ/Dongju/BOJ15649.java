import java.io.*;
import java.util.*;

public class BOJ15649 {
    public static int n;
    public static int m;
    public static int[] results;
    public static boolean [] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        results = new int[m];
        visit = new boolean [n];
        for(int i=0; i<n; i++){
            visit[i] = false;
        }
        backTracking(0);
    }

    public static void backTracking(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int result : results) {
                sb.append(result + " ");
            }
            System.out.println(sb);
        }

        else {
            for (int i = 0; i < n; i++) {
                if (visit[i] == true)
                    continue;
                else {
                    visit[i] = true;
                    results[depth] = i+1;
                    backTracking(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}