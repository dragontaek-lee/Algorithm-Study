import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> usedWords = new HashSet<>();

        int person = 2;
        usedWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt((words[i-1].length())-1) != words[i].charAt(0)) {
                answer[0] = person;
                answer[1] = (int)Math.ceil((double)(i + 1) / n);
                break;
            }
            
            if (usedWords.contains(words[i])) {
                answer[0] = person;
                answer[1] = (int)Math.ceil((double)(i + 1) / n);
                break;
            }
            
            usedWords.add(words[i]);
            
            if (person == n) {
                person = 1;
                continue;
            }
            person++;
        }

        return answer;
    }
}