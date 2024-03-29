import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * greedy -> 무거운, 가벼운거부터가 아닌 조건에 만족하는 것 부터 
 */

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int lightestIdx = 0;
        int heaviestIdx = people.length - 1;
        
        while (lightestIdx <= heaviestIdx) {
            if (people[lightestIdx] + people[heaviestIdx] > limit) {
                heaviestIdx--;
            } else {
                lightestIdx++;
                heaviestIdx--;
            }
            answer++;
        }
        
        return answer;
    }
}
