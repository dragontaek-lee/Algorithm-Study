import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "push_back":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.poll() + "\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peek() + "\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
