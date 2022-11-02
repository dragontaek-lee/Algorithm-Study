import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N,M;
    static int[] cases;
    static BufferedWriter bw;

    public static void backtracking(int depth) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(cases[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j = 1; j < N+1; j++){
            if(depth == 0 || j >= cases[depth-1]){
                cases[depth] = j;
                backtracking(depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cases = new int[N];

        backtracking(0);

        bw.flush();
        bw.close();
    }
}
