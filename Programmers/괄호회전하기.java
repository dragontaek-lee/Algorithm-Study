import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

class 괄호회전하기 {
    static int count = 0;
    private void checkAvailable(LinkedList<Character> bracketSet) {
        Stack<Character> stack = new Stack<>();
        boolean isVal = true;
        
        loop:
        for (int i = 0; i < bracketSet.size(); i++) {
            Character target = bracketSet.get(i);
            switch(target) {
                case '[':
                case '(':
                case '{':
                    stack.push(target);
                    break;
                case ']':
                    if(!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isVal = false;
                        break loop;
                    }
                    break;
                case ')':
                    if(!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isVal = false;
                        break loop;
                    }
                    break;
                case '}':
                    if(!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        isVal = false;
                        break loop;
                    }
                    break;
                default:
                    break;
                }
            }
        
            if(stack.size() == 0 && isVal) {
                count++;
            } 
    }
    
    public int solution(String s) {
        LinkedList<Character> bracketSet = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            bracketSet.offer(s.charAt(i));
        }
        
        for (int i = 0; i < s.length()-1; i++) {
            if(i != 0) {
                Character pollChar = bracketSet.poll();
                bracketSet.offer(pollChar);   
            }
            checkAvailable(bracketSet);
        }
        
        return count;
    }
}