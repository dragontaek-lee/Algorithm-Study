import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int answer = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == target) {
                    stack.pop();
                    continue;
                } 
            } 
            stack.push(target);
        }

        if (stack.size() == 0) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}