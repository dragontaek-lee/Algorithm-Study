/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 * 생 구현
 */

public class 숫자의표현 {

    class Solution {
        public int solution(int n) {
            int answer = 1;
            int start = 1;
            
            while (start != n) {
                int total = 0;
                for (int i = start; i <= n; i++) {
                    total += i;
                    
                    if (total == n) {
                        answer++;
                        continue;
                    }
                    
                    if (total > n) {
                        break;
                    }
                 }
                start++;
            }
            
            
            return answer;
        }
    }
}
