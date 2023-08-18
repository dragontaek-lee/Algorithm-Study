package GoormLevel;

import java.io.*;
import java.util.*;

class 이진수정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Integer[] array = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				int countA = Integer.bitCount(a);
      	int countB = Integer.bitCount(b);

      	if (countA == countB) {
      		return Integer.compare(b, a); 
      	}

      	return Integer.compare(countB, countA); 
			}
    });
		
		System.out.println(array[K-1]);
	}
}
