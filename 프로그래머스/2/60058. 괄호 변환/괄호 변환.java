import java.util.*;

class Solution {
    private boolean isValidString(String str) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            String target = String.valueOf(str.charAt(i));
            if (stack.isEmpty()) {
                stack.push(target);
            } else {
                String peek = stack.peek();
                if (peek.equals("(")) {
                    if (target.equals(")")) {
                        stack.pop();
                    } else {
                        stack.push(target);
                    }
                } 
            }
        }
        
        return stack.size() == 0;
    }
    
    private int isBalanceString(String str) {
        int countLeft = 0;
        int countRight = 0;
        int index = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                countLeft++;
            } else {
                countRight++;
            }
            
            if (countLeft == countRight) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    private String convertToCorrectString(String str) {
        String sliceString = str.substring(1, str.length() - 1);
        
        String convertedString = "";
        
        for (int i = 0; i < sliceString.length(); i++) {
            if (sliceString.charAt(i) == ')') {
                convertedString += '(';
            } else {
                convertedString += ')';
            }
        }
        
        return convertedString;
    }
    
    private String dfs(String str) {
        if (str.isEmpty()) {
            return "";
        }
        
        int index = isBalanceString(str);
        String u = str.substring(0, index + 1);
        String v = str.substring(index + 1);
        
        if (isValidString(u)) {
            return u + dfs(v);
        } else {
            return "(" + dfs(v) + ")" + convertToCorrectString(u);
        }
    }
    
    
    public String solution(String p) {
        String answer = dfs(p);

        return answer;
    }
}