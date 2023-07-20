package Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static int[] stack;
	public static int size = -1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        stack = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            switch(st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop() + "\n");
                    break;
                case "size":
                    sb.append(size() + "\n");
                    break;
                case "empty":
                    sb.append(empty() + "\n");
                    break;
                case "top":
                    sb.append(top() + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int i){
        size++;
        stack[size] = i; 
    }

    public static int pop(){
        if(size == -1) return -1;
        else return stack[size--];
    }

    public static int size(){
        return size+1;
    }

    public static int empty(){
        if(size == -1) return 1;
        else return 0;
    }

     public static int top(){
        if(size == -1) return -1;
        return stack[size];
    }
}
