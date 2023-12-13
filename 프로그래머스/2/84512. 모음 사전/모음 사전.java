import java.util.*;

class Solution {
    public static String[] words = {"A", "E", "I", "O", "U"};
    public static boolean[] visited = new boolean[5];
    public static List<String> wordList = new ArrayList<>();
    
    public void dfs(String currentWord, String word) {
        wordList.add(currentWord);
        for (int i = 0; i < words.length; i++) {
            String target = currentWord.concat(words[i]);
            if (target.length() <= 5) {
                dfs(target, word);
            }
        }
    }
    
    public int solution(String word) {
        for (int i = 0 ; i < 5; i++) {
            dfs(words[i], word);   
        }
        
        Collections.sort(wordList);
        
        int count = 1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(word)) {
                break;
            }
            count++;
        }
        
        return count;
    }
}