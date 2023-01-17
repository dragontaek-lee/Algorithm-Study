import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ1966 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<int []> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++) {
                queue.offer(new int [] { j, Integer.parseInt(st.nextToken()) });
            }

            int count = 0;
            
            while(!queue.isEmpty()) {
                int head [] = queue.poll();

                boolean isMax = true;

                for(int k = 0; k < queue.size(); k++) {
                    if(head[1] < queue.get(k)[1]) {
                        queue.offer(head);

                        for(int l = 0; l < k; l++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) {
                    continue;
                } 

                count++;

                if(head[0] == m) {
                    sb.append(count + "\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
