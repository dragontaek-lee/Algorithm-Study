package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ24416 {
    public static int fibRecursion(int n, int count) {
        if (n == 1 || n == 2) {
            count++;
            return count;
        }  
        else return (fibRecursion(n - 1, count) + fibRecursion(n - 2, count));
    }

    public static int fibDynamic(int n, int count) {
        int[] array = new int[n+1];
        array[1] = array[2] = 1;
        for(int i = 3; i <= n; i++) {
            count++;
            array[i] = array[i-1] + array[i-2];
        }
        return count;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int RecCount = 0;
        int dynamicCount = 0;
        RecCount = fibRecursion(n, RecCount);
        dynamicCount = fibDynamic(n, dynamicCount);

        System.out.println(RecCount+" "+dynamicCount);
    }
}
