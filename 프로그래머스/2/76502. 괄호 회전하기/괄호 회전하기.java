import java.util.*;

class Solution {
    public boolean isBracket(List<Character> brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.size(); i++) {
            Character letter = brackets.get(i);
            if (stack.isEmpty()) {
                stack.push(letter);
            } else {
                if (letter.equals('{') || letter.equals('(') || letter.equals('[')) {
                    stack.push(letter);
                } else if(letter.equals('}')) {
                    if (stack.peek().equals('{')) {
                        stack.pop();
                    } else {
                        stack.push(letter);
                    }        
                } else if(letter.equals(']')) {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        stack.push(letter);
                    }       
                } else if(letter.equals(')')) {
                    if (stack.peek().equals('(')) {
                        stack.pop();
                    } else {
                        stack.push(letter);
                    }         
                }
            }
        }

        return stack.size() == 0;
    }
    
    public int solution(String s) {
        int answer = -1;

        char[] array = s.toCharArray();
        LinkedList<Character> brackets = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            brackets.add(array[i]);
        }

        int count = 0;
        for (int i = 0 ; i < brackets.size(); i++) {
            if (isBracket(brackets)) {
                count++;
            }   
            Character poll = brackets.poll();
            brackets.offer(poll);
        }

        return count;
    }
}