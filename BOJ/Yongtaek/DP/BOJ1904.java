package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
    static int [] tile = new int [1000001];
    public static void chkTile(int n) {
        for(int i = 3; i <= n; i++) {
            tile[i] = (tile[i-2] + tile[i-1]) % 15746;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tile[0] = 0;
        tile[1] = 1;
        tile[2] = 2;
        chkTile(n);
        System.out.println(tile[n]);
    }
}
