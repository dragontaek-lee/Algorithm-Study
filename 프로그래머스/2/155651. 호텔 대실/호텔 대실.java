import java.util.*;

class Solution {
    private int[][] convertBookTimeToMinute(String[][] book_time) {
        int[][] convertedBookTime = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                String[] timeInfo = book_time[i][j].split(":");
                int hour = Integer.parseInt(timeInfo[0]);
                int minute = Integer.parseInt(timeInfo[1]);
                
                if (j == 1) {
                    minute += 10;
                } 
                
                convertedBookTime[i][j] = (hour * 60) + minute;
            }
        }
        
        return convertedBookTime;
    }
    
    private int countDuplicated(int[][] convertedBookTime) {
        int max = 0;
        for (int i = 0; i < convertedBookTime.length; i++) {
            int endTime = convertedBookTime[i][1];
            int count = 1;
            for (int j = i + 1; j < convertedBookTime.length; j++) {
                if (endTime > convertedBookTime[j][0]) {
                    count++;
                }
            }
            
            if (count > max) {
                max = count;
            }
        }
        
        return max;
    }
    
    public int solution(String[][] book_time) {
        int[][] convertedBookTime = convertBookTimeToMinute(book_time);
        
        Arrays.sort(convertedBookTime, (arr1, arr2) -> {
            return arr1[1] - arr2[1];
        });
        
        int answer = countDuplicated(convertedBookTime);
        
        return answer;
    }
}