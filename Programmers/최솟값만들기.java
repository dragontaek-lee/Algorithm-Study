package Programmers;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */

public class 최솟값만들기 {

    class Solution
    {
        public int solution(int []A, int []B)
        {
            ArrayList<Integer> listA = new ArrayList<Integer>();
            ArrayList<Integer> listB = new ArrayList<Integer>();
            
            for (int i = 0; i < A.length; i++) {
                listA.add(A[i]);
                listB.add(B[i]);
            }

            Collections.sort(listA);
            Collections.sort(listB, Comparator.reverseOrder());
            
            int answer = 0;
            
            for (int i = 0; i < A.length; i++) {
                answer += listA.get(i) * listB.get(i);
            }

            return answer;
        }
    }
}
