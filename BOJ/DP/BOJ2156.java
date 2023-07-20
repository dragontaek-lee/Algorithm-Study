package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[10001];
        int[] dp = new int[10001];

        for(int i = 1; i < n + 1; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = array[1];
        dp[2] = array[1] + array[2];

        for(int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(dp[i-2], dp[i-3] + array[i-1]) + array[i], dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}
