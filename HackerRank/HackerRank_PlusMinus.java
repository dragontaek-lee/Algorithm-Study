package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
    - https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-week-day-one
    - long형 
    - String.format("%.{자리수}f", {target})
*/

class Result {
    public static void plusMinus(List<Integer> arr) {
        double countPositive = 0;
        double countNegative = 0;
        double countZero = 0;
        
        for (int num : arr) {
            if (num == 0) {
                countZero++;
            } else if (num > 0) {
                countPositive++;
            } else if (num < 0) {
                countNegative++;
            }
        };
        
        double positive = (countPositive / arr.size());
        double negative = (countNegative / arr.size());
        double zero = (countZero / arr.size());
        
        System.out.println(String.format("%.6f", positive));
        System.out.println(String.format("%.6f", negative));
        System.out.println(String.format("%.6f", zero));
    }
}

public class HackerRank_PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
