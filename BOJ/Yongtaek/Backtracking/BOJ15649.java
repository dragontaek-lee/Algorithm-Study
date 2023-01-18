package Backtracking;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N,M;
    static int [] cases;
    static boolean[] visited;
    static BufferedWriter bw;

    static private void backTracking(int currentIndex) throws IOException{
        if(currentIndex == M) {
            for(int j = 0; j < M; j++){
                bw.write(cases[j]+ " ");
            }
            bw.write("\n");
            return;
        }
        
        for(int i = 1; i < N+1 ; i++){
            if(!visited[i]){
                visited[i] = true;
                cases[currentIndex] = i;
                backTracking(currentIndex+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        cases = new int[M];

        backTracking(0);

        bw.flush();
        bw.close();
    }
}