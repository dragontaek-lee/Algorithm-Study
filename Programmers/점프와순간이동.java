/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        
        while(n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        
        return ans;
    }
}