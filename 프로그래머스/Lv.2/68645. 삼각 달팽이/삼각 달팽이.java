class Solution {
    public static int[][] snail;
    
    public String getDirection(String currentDirection, int i, int j) {
        if (currentDirection.equals("DOWN")) {
            i++;
        } else if (currentDirection.equals("RIGHT")) {
            j++;
        } else {
            i--;
            j--;
        }
        
        if (i < 0 || j < 0 || i >= snail.length || j >= snail.length) {
            currentDirection = getNextDirection(currentDirection);
        } else if (snail[i][j] != 0) {
            currentDirection = getNextDirection(currentDirection);
        }
        
        return currentDirection;
    }
    
    public String getNextDirection(String currentDirection) {
        if (currentDirection.equals("DOWN")) {
            return "RIGHT";
        } else if (currentDirection.equals("RIGHT")) {
            return "DIAGONAL";
        } else {
            return "DOWN";
        }
    }
    
    public int[] solution(int n) {
        int length = (n * (n + 1)) / 2;
        int[] answer = new int[length]; 
        snail = new int[n][n];
        
        int num = 1;
        int i = 0;
        int j = 0;
        String direction = "DOWN";
        
        while (num != length + 1) {
            snail[i][j] = num;
            num++;
            
            direction = getDirection(direction, i, j);
            
            if (direction.equals("DOWN")) {
                i++;
            } else if (direction.equals("RIGHT")) {
                j++;
            } else {
                i--;
                j--;
            }
        }
        
        int answerIndex = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (snail[k][l] == 0) {
                    continue;
                } else {
                    answer[answerIndex] = snail[k][l];
                    answerIndex++;
                }
            }
        }
        
        return answer;
    }
}