package Backtracking;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N,M;
    static int[] cases;
    static BufferedWriter bw;

    public static void backTracking(int depth, int start) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(cases[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j = start; j < N+1 ; j++){
            cases[depth] = j;
            backTracking(depth+1,j+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cases = new int[M];

        backTracking(0,1);

        bw.flush();
        bw.close();
    }
}