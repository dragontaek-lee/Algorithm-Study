package Sort;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class BOJ2587 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[5];

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int avg = 0;
        for(int i = 0; i < 5; i++) {
            avg += arr[i];
        }

        System.out.println((int) (avg / 5));
        System.out.println(arr[2]);
    }
}
