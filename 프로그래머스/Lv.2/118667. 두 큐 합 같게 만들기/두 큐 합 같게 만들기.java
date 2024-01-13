import java.util.*;

class Solution {
    public long getSum(int[] targetQueue) {
        long sum = 0;
        for (int i = 0; i < targetQueue.length; i++) {
            sum += (long) targetQueue[i];
        }
        
        return sum;
    }
    
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        
        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            queueOne.add(queue1[i]);
            queueTwo.add(queue2[i]);
        }
        
        while (sum1 != sum2) {
            if (answer > (queueOne.size() + queueTwo.size() * 2)) {
                return -1;
            }                
            
            if (sum1 > sum2) {
                int pollOne = queueOne.poll();
                sum1 -= (long) pollOne;
                queueTwo.offer(pollOne);
                sum2 += (long) pollOne;
            } else {
                int pollTwo = queueTwo.poll();
                sum2 -= (long) pollTwo;
                queueOne.offer(pollTwo);
                sum1 += (long) pollTwo; 
            } 
            answer++;
        }
        
        return answer;
    }
}