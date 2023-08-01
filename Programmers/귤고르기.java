import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> sizeSet = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int size = tangerine[i];
            if (sizeSet.containsKey(size)) {
                sizeSet.put(size, sizeSet.get(size) + 1);
                continue;
            } 
            sizeSet.put(size, 1);
        }
            
        List<Integer> keySet = new ArrayList<>(sizeSet.keySet());

        keySet.sort((o1, o2) -> {
            return sizeSet.get(o2) - sizeSet.get(o1);
        });
        
        
        for (int key : keySet) {
             if(k <= 0) {
                break;
            }
            k -= sizeSet.get(key);
            answer++;
        }
        
        return answer;
    }
}