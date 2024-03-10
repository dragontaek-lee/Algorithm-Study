import java.util.*;

class Solution {    
    private void sortData(int[][] data, int col) {
        Arrays.sort(data, (arr1, arr2) -> {
            if (arr1[col] == arr2[col]) {
                return arr2[0] - arr1[0];
            }
            
            return arr1[col] - arr2[col];
        });
    }
    
    private int[] getRemainders(int[][] data, int row_begin, int row_end) {
        int[] remainders = new int[row_end - row_begin + 1];
        
        int index = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] targetRowData = data[i];
            
            int sum = 0;
            for (int j = 0; j < targetRowData.length; j++) {
                sum += (targetRowData[j] % (i + 1));
            }
            
            remainders[index++] = sum;
        }
        
        return remainders;
    }
    
    private int getXORbit(int[] remainders) {
        int answer = remainders[0];
        for (int i = 1; i < remainders.length; i++) {
            answer = (answer ^ remainders[i]);
        }
        
        return answer;
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        sortData(data, col - 1);
        int[] remainders = getRemainders(data, row_begin - 1, row_end - 1);
        
        answer = getXORbit(remainders);
        return answer;
    }
}