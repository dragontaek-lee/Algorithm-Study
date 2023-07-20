import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ2798 {
    static int m,n;
    static int arr[];
    static int max = 0;
    static int current = 0;
    static int tmp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(current <= n-3) {
            for(int i = current + 1; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    tmp = arr[current] + arr[i] + arr[j];
                    if(tmp <= m && tmp >= max) max = tmp;
                }
            }
            current++;
        }

        System.out.println(max);
    }

    
}
