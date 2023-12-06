import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] newElements = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
            newElements[i + elements.length] = elements[i]; 
        }
        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int num = 0;
                for (int k = 0; k < i; k++) {
                    num += newElements[j+k];
                }
                set.add(num);
            }
        }
        return set.size();
    }
}