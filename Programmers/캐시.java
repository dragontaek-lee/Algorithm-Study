import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */

class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> cache = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                answer += 1;
                cache.add(city);
            } else {
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                answer += 5;
                cache.add(city);
            }
        }
        
        return answer;
    }
}