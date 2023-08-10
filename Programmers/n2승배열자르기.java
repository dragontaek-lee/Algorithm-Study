import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */

class n2승배열자르기 {
    public long[] solution(int n, long left, long right) {
        long[] list = new long[(int)(right - left) + 1];
          
        for (long i = left; i <= right; i++) {
            long x = (i / n) + 1;
            long y = (i % n) + 1;
            long value = Math.max(x,y);
            list[(int)(i - left)] = value;
        }
        
        return list;
    }
}