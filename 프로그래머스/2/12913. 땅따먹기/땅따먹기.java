class Solution {
    public int calculateTotalMax(int row, int col, int[][] land) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (i == col) continue;
            max = Math.max(land[row - 1][i], max);
        }
        
        return max;
    }
    
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += calculateTotalMax(i, j, land);
            }
        }
        
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(land[land.length - 1][i], max);
        }

        return max;
    }
}