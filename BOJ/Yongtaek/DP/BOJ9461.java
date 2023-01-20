package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ9461 {
    static BigInteger [] len = new BigInteger[101];

    public static BigInteger clacLen(int n) {
        if(n > 5) {
            for(int i = 6; i <= n; i++) {
                len[i] = len[i-1].add(len[i-5]);  
            }
        }
        return len[n];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        len[0] = BigInteger.valueOf(1);
        len[1] = BigInteger.valueOf(1);
        len[2] = BigInteger.valueOf(1);
        len[3] = BigInteger.valueOf(1);
        len[4] = BigInteger.valueOf(2);
        len[5] = BigInteger.valueOf(2);

        for(int i = 0; i < n; i++) {
            sb.append(clacLen(Integer.parseInt(br.readLine()))+ "\n");
        }

        System.out.println(sb);
    }
}
