import java.util.*;

class Solution {
    private ArrayList<Integer> getRemainers (int[] array) {
        ArrayList<Integer> remainderArray = new ArrayList<>();
        
        Arrays.sort(array);
        
        for (int i = array[array.length - 1]; i >= 2 ; i--) {
            boolean isRemainder = true;
            for (int j = 0 ; j < array.length; j++) {
                if (array[j] % i != 0) {
                    isRemainder = false;
                    break;
                }
            }
            
            if (isRemainder) {
                remainderArray.add(i);
            }
        }
        
        return remainderArray;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        ArrayList<Integer> remaindersA = getRemainers(arrayA);
        ArrayList<Integer> remaindersB = getRemainers(arrayB);
        
        for (int i = 0; i < remaindersA.size(); i++) {
            int target = remaindersA.get(i);
            
            boolean isAnswerCandidate = true;
            
            for (int j = 0; j < arrayB.length; j ++) {
                if (arrayB[j] % target == 0) {
                    isAnswerCandidate = false;
                    break;
                }
            }
            
            if (isAnswerCandidate && target > answer) {
                answer = target;
            }
        }
        
        for (int i = 0; i < remaindersB.size(); i++) {
            int target = remaindersB.get(i);
            
            boolean isAnswerCandidate = true;
            
            for (int j = 0; j < arrayA.length; j ++) {
                if (arrayA[j] % target == 0) {
                    isAnswerCandidate = false;
                    break;
                }
            }
            
            if (isAnswerCandidate && target > answer) {
                answer = target;
            }
        }
        
        return answer;
    }
}