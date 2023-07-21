/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */

public class 예상대진표 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;
    
            while(a != b) {
                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer++;
            }
    
            return answer;
        }
    }
}
