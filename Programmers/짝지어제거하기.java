import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * pop, push, peek, empty
 */

public class 짝지어제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> pairs = new Stack<Character>();
            
            for (int i = 0; i < s.length(); i++) {
                if (!pairs.empty() && pairs.peek() == s.charAt(i)) {
                    pairs.pop();
                    continue;
                } 
                
                pairs.push(s.charAt(i));
            }

            if (pairs.size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
