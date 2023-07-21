/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 * Integer.toBinaryString(number)
 */

public class 다음큰숫자 {
    class Solution {
        private int countOne(String binary) {
            int count = 0;
            
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }
            return count;
        }
        
        public int solution(int n) {
            int answer = n + 1;
            String inputBinary = Integer.toBinaryString(n);
            int inputOneCount = countOne(inputBinary);
            
            while(true) {
                String targetBinary = Integer.toBinaryString(answer);
                int targetOneCount = countOne(targetBinary);
                
                if (targetOneCount == inputOneCount) {
                    break;
                }
                answer++;
            }
            
            return answer;
        }
    }
}
