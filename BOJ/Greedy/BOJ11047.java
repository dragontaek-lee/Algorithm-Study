package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] moneys = new Integer[n];

        for(int i = 0 ; i < n; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(moneys, Collections.reverseOrder());

        int count = 0;
        int index = 0;

        while(k != 0) {
            if(k - moneys[index] >= 0) {
                k = k - moneys[index];
                count++;
                continue;
            } 

            index++;
        }

        System.out.println(count);
    }
}
