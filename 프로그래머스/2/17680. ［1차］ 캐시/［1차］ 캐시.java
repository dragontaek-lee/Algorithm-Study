import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> cache = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                time += 1;
            } else {
                if (cacheSize > 0) {
                    if (cache.size() < cacheSize) {
                        cache.add(city);
                    } else {
                        cache.remove(0);
                        cache.add(city);
                    }                  
                }
    
                time += 5;
            }
        }
        
        return time;
    }
}