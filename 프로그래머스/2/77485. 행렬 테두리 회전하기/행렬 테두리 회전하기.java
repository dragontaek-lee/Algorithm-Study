import java.util.*;

class Solution {
    static int[][] matrix;
    
    private void init(int rows, int columns) {
        int num = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
    }
    
    private int rotate(int startX, int startY, int endX, int endY, int rows, int columns) {
        boolean[][] visited = new boolean[rows + 1][columns + 1];
        
        int x = startX;
        int y = startY;
        int rotateState = 0;
        int value = matrix[x+1][y];
        
        int min = Integer.MAX_VALUE;
        
        while (true) {
            if (visited[x][y]) {
                break;
            }
            int tempValue = matrix[x][y];
            matrix[x][y] = value;
            value = tempValue;
            visited[x][y] = true;
            
            min = Math.min(min, matrix[x][y]);
            
            if (x == startX && y == endY) {
                rotateState = 1;
            }
            
            if (x == endX && y == endY) {
                rotateState = 2;
            }
            
            if (x == endX && y == startY) {
                rotateState = 3;
            }
            
            if (rotateState == 0) {
                y += 1;
            } else if (rotateState == 1) {
                x += 1;
            } else if (rotateState == 2) {
                y -= 1;
            } else {
                x -= 1;
            }
        }
        
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows + 1][columns + 1];
        init(rows, columns);
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int min = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3], rows, columns);
            answer[i] = min;
        }
        
        return answer;
    }
}