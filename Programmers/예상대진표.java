import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 * 분할정복을 처음에 생각했는데, 단순한 반복문으로도 충분히 풀 수 있다
 */

public class 예상대진표 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 1;
    
            ArrayList<Integer> players = new ArrayList<Integer>();
            
            for (int i = 1; i < n+1; i++) {
                players.add(i);
            }
            
            loop:
            while(true) {
                ArrayList<Integer> nextRoundPlayers = new ArrayList<Integer>();
                
                for (int i = 0; i < players.size(); i +=2) {
                    if (players.get(i) == a && players.get(i+1) == b) {
                        break loop;
                    }
                    
                    if (players.get(i) == b && players.get(i+1) == a) {
                        break loop;
                    }
                    
                    if (players.get(i) == a) {
                        nextRoundPlayers.add(a);
                        continue;
                    }
                    
                    if (players.get(i) == b) {
                        nextRoundPlayers.add(b);
                        continue;
                    }
                    
                    if (players.get(i+1) == a) {
                        nextRoundPlayers.add(a);
                        continue;
                    }
                    
                    if (players.get(i+1) == b) {
                        nextRoundPlayers.add(b);
                        continue;
                    }
                    
                    nextRoundPlayers.add(players.get(i));
                }
                    
                answer++;
                players = nextRoundPlayers;
            }
    
            return answer;
        }
    }
}
