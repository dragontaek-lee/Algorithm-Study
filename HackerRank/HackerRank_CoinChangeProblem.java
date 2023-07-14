package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
    * https://www.hackerrank.com/challenges/coin-change/problem
    * 인덱스는 int로 casting
    * knapsack과 비슷
    * dp 초기값 채워주기 
*/

class Result {

    public static long getWays(int n, List<Long> c) {
        long[][] dp = new long[c.size()+1][n+1];
        dp[0][0] = 1;

        for (int i = 1; i < c.size()+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (c.get(i-1) <= j) {
                    dp[i][j] = (dp[i-1][j] + dp[i][(int) (j - c.get(i - 1))]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
       return dp[c.size()][n];
    }
}

public class HackerRank_CoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}