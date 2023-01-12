import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int index = 0;

        sb.append("<");
        for(int j = 0; j < n; j++) {
            index = (index + (k-1)) % queue.size();
            sb.append(queue.get(index));
            queue.remove(index);

            if(j != n-1) {
                sb.append(", ");
            }
        }
        sb.append('>');


        System.out.println(sb);
    }
}
