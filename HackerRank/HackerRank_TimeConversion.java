package HackerRank;

import java.io.*;

    /*
     * https://www.hackerrank.com/challenges/one-week-preparation-kit-time-conversion/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-week-day-one
     * 경우의 수 많이 따지기
     */


class Result {

    public static String timeConversion(String s) {
        String[] splits = s.split(":");
        String state = splits[2].substring(2,4);
        
        String hour = splits[0];
        String minute = splits[1];
        String second = splits[2].substring(0,2);
        
        if (state.equals("PM")) {
            if (!hour.equals("12")) {
                int converted = Integer.parseInt(splits[0]) + 12;
                hour = String.valueOf(converted);   
            }
        } else if (state.equals("AM")) {
            if (hour.equals("12")) {
                hour = "00";
            }
        }
        
        return hour + ":" + minute + ":" + second;
    }

}

public class HackerRank_TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
