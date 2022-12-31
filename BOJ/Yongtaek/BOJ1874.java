import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class BOJ1874 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int arr [] = new int[n];

        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int point = 0;
        for(int j = 1; j <= n; j++) {
            if(!stack.empty() && stack.peek() == arr[point]) {
                stack.pop();
                sb.append("-"  + "\n");
                point++;
                j--;
            } else {
                stack.push(j);
                sb.append("+" + "\n");
            }
        }

        boolean isPossible = true;
        if(!stack.empty()) {
            while(!stack.empty()) {
                if(stack.peek() == arr[point]){
                    stack.pop();
                    sb.append("-"  + "\n");
                    point++;
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        if(!isPossible) System.out.println("NO");
        else System.out.println(sb);
    }
}
