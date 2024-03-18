class Solution
{
    static int[][] dp;
    
    private void initBoard(int[][] board) {
        dp = new int[board.length + 1][board[0].length + 1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = board[i-1][j-1];
            }
        }
    }
    public int solution(int[][] board)
    {
        int answer = -1;
        initBoard(board);
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] != 0) {
                    int left = dp[i-1][j];
                    int upper = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(left, upper), diagonal) + 1;
                }
                
                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer * answer;
    }
}