import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> list = Arrays.asList(s.split(" "))
            .stream()
            .map(data -> Integer.parseInt(data))
            .collect(Collectors.toList());
        
        int max = Collections.max(list);
        int min = Collections.min(list);
        
        return min + " " + max;
    }
}