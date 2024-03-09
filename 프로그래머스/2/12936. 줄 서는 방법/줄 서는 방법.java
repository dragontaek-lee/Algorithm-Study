import java.util.*;

public class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[n];

        long fn = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fn *= i;
        }
        
        k--;
        
        int index = 0;
            
        while (n > 0) {
            fn /= n;
            int targetIndex = (int) (k / fn);
            answer[index++] = list.get(targetIndex);
            list.remove(targetIndex);
            k %= fn;
            n--;
        }
        
        return answer;
    }
}
