import java.util.*;

class Solution {
    public static boolean[] visited;
    public static Set<String> numberSet = new HashSet<>();
    
    public void dfs(String number, String numbers) {
        if (!number.equals("")) {
           numberSet.add(number); 
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            String newNumber = number.concat(String.valueOf(numbers.charAt(i)));
            newNumber = Integer.toString(Integer.parseInt(newNumber));
            visited[i] = true;
            dfs(newNumber, numbers);
            visited[i] = false;
        }
    }
    
    public boolean isDemical(String number) {
        int targetNum = Integer.parseInt(number); 
        
        if (targetNum <= 1) {
            return false;
        }
        
        if (targetNum == 2 || targetNum == 3) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(targetNum); i++) {
            if (targetNum % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        dfs("", numbers);
        
        for (String number: numberSet) {
            if (isDemical(number)) {
                answer++;
            }
        }
        
        return answer;
    }
}