package Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9012 {
    public static boolean chkVPS(char[] arr) {
        int size = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(') size++;
            else size--;

            if(size == -1) return false;
        }

        if(size == 0) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n ; i++) {
            char [] arr = br.readLine().toCharArray();
            if(chkVPS(arr)) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }

        System.out.println(sb);
    }
}
