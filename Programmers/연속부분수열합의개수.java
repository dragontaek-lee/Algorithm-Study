import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int[] newElements = new int[(elements.length * 2) - 1];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        
        for (int i = 0; i < elements.length - 1; i++) {
            newElements[elements.length + i] = elements[i];
        }
        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += newElements[k];   
                }
                set.add(sum);
            }
        }
            
        return set.size();
    }
}