package Sort;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1181 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        String arr[] = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String e1, String e2){
                if(e1.length() == e2.length()){
                    return e1.compareTo(e2);
                } else {
                    return e1.length() - e2.length();
                }
            }
        });

        for(int i = 0; i < n ; i++) {
            if(i == 0 || !arr[i].equals(arr[i-1])){
                sb.append(arr[i] + "\n");
            } 
        }

        System.out.println(sb);
    }
}
