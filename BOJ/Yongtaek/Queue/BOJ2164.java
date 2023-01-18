package Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ2164 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n ; i++) {
            queue.offer(i);
        }

        while(queue.size() != 1) {
            queue.pop();
            int poped = queue.pop();
            queue.offer(poped);
        }

        System.out.println(queue.peek());
    }
}
