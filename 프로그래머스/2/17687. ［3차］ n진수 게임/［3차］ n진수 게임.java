import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        boolean isStarted = false;
        int countGap = 0;
        int order = 1;
        for (int i = 1 ; i <= t * m; i++) {
            int target = i - 1;
            String convertedTarget = Integer.toString(target, n);
            
            for (int j = 0; j < convertedTarget.length(); j++) {
                Character digit = convertedTarget.charAt(j);
                if (!isStarted && (order == p)) {
                    sb.append(Character.toUpperCase(digit));
                    isStarted = true;
                    countGap++;
                } else if (isStarted && order == p + (m * countGap) && sb.length() < t) {
                    sb.append(Character.toUpperCase(digit));
                    countGap++;
                }
                order++;
            }
        }
        
        return sb.toString();
    }
}