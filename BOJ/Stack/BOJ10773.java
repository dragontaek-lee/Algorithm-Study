package Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10773 {
    static int[] stack;
    static int size = -1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(size != -1) size--;
            } else {
                size++;
                stack[size] = num;
            }
        }

        int sum = 0;
        for(int j = 0; j < size+1; j++) {
            sum += stack[j];
        }

        System.out.println(sum);
    }
}
