class Solution {
    public static int[] moveX = {0, -1, 0, 1};
    public static int[] moveY = {1, 0, -1, 0};
    public static boolean[][][] visited = new boolean[11][11][4];
    
    public int visitCalculate(int x, int y, String dirs) {
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            Character direction = dirs.charAt(i);

            int moveIndex;
            switch (direction) {
                case 'U':
                    moveIndex = 0;
                    break;
                case 'L':
                    moveIndex = 1;
                    break;
                case 'D':
                    moveIndex = 2;
                    break;
                case 'R':
                    moveIndex = 3;
                    break;
                default:
                    moveIndex = 0;
                    break;
            };

            int movedX = x + moveX[moveIndex];
            int movedY = y + moveY[moveIndex];

            if (movedX < 0 || movedY < 0 || movedX > 10 || movedY > 10) {
                continue;
            }

            if (!visited[movedX][movedY][moveIndex]) {

                visited[movedX][movedY][moveIndex] = true;

                int reverseDirection = moveIndex % 2 == 0 
                    ? 2 - moveIndex : 4 - moveIndex;

                visited[x][y][reverseDirection] = true;

                answer++; 
            }
            x = movedX;
            y = movedY;
        }
        return answer;
    };
    
    public int solution(String dirs) {
        return visitCalculate(5, 5, dirs);
    }
}