class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        int col = 0;
        int row = 0;
        for (int i = 1; i < sum; i++) {
            if (sum % i != 0) {
                continue;  
            }
            int j = sum / i;
            col = i;
            row = j; 
            
            if (brown == ((col * 2) + (row * 2) - 4)) {
                break;
            }
        }
    
        answer[0] = row;
        answer[1] = col;
        return answer;
    }
}