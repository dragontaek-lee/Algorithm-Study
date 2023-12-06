import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (map.get(tangerine[i]) == null) {
                map.put(tangerine[i], 1);
            } else {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            }
        }
        
        List<Integer> mapList = new ArrayList<>(map.values());
        
        Collections.sort(mapList, Collections.reverseOrder());
        
        int amount = 0;
        for (int i = 0; i < mapList.size(); i++) {
            amount += mapList.get(i);
            answer++;
            
            if (amount >= k) {
                break;
            }
        }
        
        return answer;
    }
}