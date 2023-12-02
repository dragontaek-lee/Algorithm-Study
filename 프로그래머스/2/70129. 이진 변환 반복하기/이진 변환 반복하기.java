import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        
        int temp = 0;
        while (!s.equals("1")) {
            int prevLen = s.length();
            s = String.join("",s.split("0"));          
            int nextLen = s.length();
            
            s = Integer.toBinaryString(nextLen);  
            
            count += 1;
            zeroCount += prevLen - nextLen;
        }
        
        answer[0] = count;
        answer[1] = zeroCount;
        
        return answer;
    }
}