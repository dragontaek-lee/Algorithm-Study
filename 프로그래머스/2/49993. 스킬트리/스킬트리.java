import java.util.*;

class Solution {
    private Stack<Character> initStack (char[] skillArray) {
        Stack<Character> stack = new Stack<>();
        for (int i = skillArray.length - 1; i >= 0; i--) {
            stack.push(skillArray[i]);
        }
        
        return stack;
    }
    
    private boolean checkIncludes (char[] skillArray, char target) {
        boolean includes = false;
        for (int i = 0; i < skillArray.length; i++) {
            if (skillArray[i] == target) {
                includes = true;
            }
        }
        
        return includes;
    }
    
    public int solution(String skill, String[] skill_trees) {
        char[] skillArray = skill.toCharArray();

        int answer = 0;    
        for (int i = 0; i < skill_trees.length; i++) {
            Boolean isValid = true;
            Stack<Character> stack = initStack(skillArray);
            String skillTree = skill_trees[i];
            
            for (int j = 0; j < skillTree.length(); j++) {
                if (checkIncludes(skillArray, skillTree.charAt(j))) {
                    if (!stack.isEmpty() && stack.peek() == skillTree.charAt(j)) {
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
}