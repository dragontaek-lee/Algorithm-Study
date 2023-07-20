package Backtracking;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ9663 {
    static int N;
    static boolean[] visited;
    static int[] cases;
    static BufferedWriter bw;
    static int count;
    static boolean isDiag;

    public static void chkDiag(int depth, int number){
        for(int j = depth-1; j >= 0; j--){
            if((cases[j] == (number - (depth-j))) || (cases[j] == (number + (depth-j)))){
                isDiag = true;
                break;
            }
        }
    }

    public static void execVisit(int depth, int number) throws IOException{
        visited[number] = true;
        cases[depth] = number;
        backTracking(depth+1);
        visited[number] = false;
    }

    public static void backTracking(int depth) throws IOException{
        if(depth == N){
            count++;
            return;
        }

        for(int i = 1; i < N+1; i++){
            if(!visited[i]){
                if(depth > 0){
                    chkDiag(depth, i);
                    if(isDiag) {
                        isDiag = false;
                    } else {
                        execVisit(depth,i);
                    }
                } else {
                    execVisit(depth,i);
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
