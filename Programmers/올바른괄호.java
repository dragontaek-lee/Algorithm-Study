package Programmers;
import java.util.*;

public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<Character>();
            boolean answer = true;
            
            for (int i = 0; i < s.length(); i++) {
                char bracket = s.charAt(i);
                
                if (bracket == '(') {
                    stack.push(bracket);
                } else if (bracket == ')') {
                    if (stack.empty()) {
                        answer = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if (!stack.empty()) {
                answer = false;
            }
    
            return answer;
        }
    } 
}
