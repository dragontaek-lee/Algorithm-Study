import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s," ",true);
        
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            String convertedString = "";

            for (int j = 0; j < word.length(); j++) {
                char letter = word.charAt(j);
                if (j == 0) {
                   if (Character.isLowerCase(letter)) {
                        sb.append(Character.toUpperCase(letter));
                        continue;
                    }  
                } else {
                    if (Character.isUpperCase(letter)) {
                        sb.append(Character.toLowerCase(letter));
                        continue;
                    }
                }
                sb.append(letter);
            }
        }
        
        return sb.toString();
    }
}