import java.io.*;
import java.util.*;

public class BOJ10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> sanggeunSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
            sanggeunSet.add(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            if (sanggeunSet.contains(Integer.parseInt(st.nextToken())))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        
        System.out.println(sb);
    }
}