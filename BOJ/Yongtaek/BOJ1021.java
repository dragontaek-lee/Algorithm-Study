import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ1021 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        
        int count = 0;
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int index = deque.indexOf(target);

            int middle;

            if(deque.size() % 2 == 0) {
                middle = (deque.size() / 2) - 1;
            } else {
                middle = (deque.size() / 2);
            }

            if(index <= middle) {
                for(int j = 0; j < index; j++) {
                    int value = deque.poll();
                    deque.offerLast(value);
                    count++;
                }
            } else {
                for(int j = deque.size(); j > index; j--) {
                    int value = deque.pollLast();
                    deque.offerFirst(value);
                    count++;
                }
            }

            deque.poll();
        }

        System.out.println(count);
    }
}
