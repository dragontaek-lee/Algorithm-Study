import java.util.*;

class Solution {
    private Queue<Integer> initQueue(int length) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= length; i++) {
            queue.offer(i);
        }
        
        return queue;
    }
    
    
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = initQueue(order.length);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < order.length; i++) {
            int target = order[i];
            
            if (!queue.isEmpty() && queue.peek() == target) {
                queue.poll();
                answer++;
                continue;
            }
            
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
                continue;
            }
            
            if (target > queue.peek()) {
                while (queue.peek() != target) {
                    int pollBox = queue.poll();
                    stack.push(pollBox);
                }
                
                queue.poll();
                answer++;
                continue;
            }    
            
            break;
        }
        
        return answer;
    }
}