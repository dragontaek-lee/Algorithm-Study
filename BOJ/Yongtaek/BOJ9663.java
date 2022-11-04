import java.io.*;
import java.util.StringTokenizer;

public class BOJ9663 {
    static int N;
    static boolean[] visited;
    static int[] cases;
    static BufferedWriter bw;
    static int count;
    static boolean isDiag;

    public static void backTracking(int depth) throws IOException{
        if(depth == N){
            count++;
            return;
        }

        for(int i = 1; i < N+1; i++){
            if(!visited[i]){
                if(depth > 0){
                    for(int j = depth-1; j >= 0; j--){
                        if((cases[j] == (i - (depth-j))) || (cases[j] == (i + (depth-j)))){
                            isDiag = true;
                            break;
                        }
                    }

                    if(isDiag) {
                        isDiag = false;
                    } else {
                        visited[i] = true;
                        cases[depth] = i;
                        backTracking(depth+1);
                        visited[i] = false;
                    }
                    
                } else {
                    visited[i] = true;
                    cases[depth] = i;
                    backTracking(depth+1);
                    visited[i] = false;
                }
            }   
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        cases = new int[N];

        count = 0;
        isDiag = false;

        backTracking(0);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        
    }
}
