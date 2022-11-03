import java.io.*;
import java.util.*;

public class BOJ9663 {
    public static int n;
    public static int [] n_table;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        n_table = new int[n];
        result = 0;

        backTracking(0);
        System.out.println(result);
    }
    public static void backTracking(int depth){
        if(depth == n) {
            result++;
            return;
        }
        for(int i= 0; i<n; i++){
            n_table[depth] = i;
            if(promising(depth)) backTracking(depth+1);
            n_table[depth] = -1;
        }
    }

    public static boolean promising(int depth){
        for(int i=0; i<depth; i++){
            if(Math.abs(n_table[i]-n_table[depth]) == Math.abs(i-depth) || n_table[i] == n_table[depth]) return false;
        }
        return true;
    }
}
