import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * 이중 for문 탈출을 위해 라벨링을 해준다 loop: + break loop;
 */

public class 영어끝말잇기 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];

            int col = n;
            int row = (int) Math.ceil((double)words.length / n);
            
            String[][] wordList = new String[row + 1][col + 1];
            Set<String> wordSet = new HashSet<String>();
            
            int index = 0;
            String prevString = "";
            Boolean hasDrop = false;
            
            loop:
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    String word = words[index];
                    
                    if (prevString != "" && prevString.charAt(prevString.length()-1) != word.charAt(0)) {
                        answer[0] = j;
                        answer[1] = i;
                        hasDrop = true;
                        break loop;
                    }
                    
                    if (wordSet.contains(word)) {
                        answer[0] = j;
                        answer[1] = i;
                        hasDrop = true;
                        break loop;
                    }
                    
                    wordList[i][j] = word;
                    wordSet.add(word);
                    prevString = word;
                    index++;
                }
            }

            if (!hasDrop) {
                answer[0] = 0;
                answer[1] = 0;
                return answer;
            }
            
            return answer;
        }
    }
}
