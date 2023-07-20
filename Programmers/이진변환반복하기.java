import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * StringBuffer - deleteCharAt
 * Integer - toBinaryString (2진수 변환)
 * 해당 메소드를 잘 활용하고 익히기
 */

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int removed = 0;
        int count = 0;
        
        StringBuffer sb;
        
        sb = new StringBuffer();
        sb.append(s);
        
        while (!sb.toString().equals("1")) {
            ArrayList<Integer> removeList = new ArrayList<Integer>();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    removeList.add(i);
                } 
            }
            
            int counts = 0;
            for (int i = 0; i < removeList.size(); i++) {
                sb.deleteCharAt(removeList.get(i) - counts);
                counts++;
            }
            
            removed += removeList.size();
            
            int convertedSize = sb.length();
            
            String binary = Integer.toBinaryString(convertedSize);
            
            sb = new StringBuffer();
            sb.append(binary);
            
            count++;
        }
        
        answer[0] = count;
        answer[1] = removed;
        
        return answer;
    }
}