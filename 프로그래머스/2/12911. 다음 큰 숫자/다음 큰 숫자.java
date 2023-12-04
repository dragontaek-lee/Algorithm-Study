import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int nLength = Integer.bitCount(n);
        
        while(true) {
            int targetLength = Integer.bitCount(answer);
            
            if (targetLength == nLength) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}