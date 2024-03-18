import java.util.*;

class Solution {
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0 , -1, 1};
    
    class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int getMenhathen(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    
    private boolean bfs(int startX, int startY, String[] place) {
        Queue<Point> queue = new LinkedList<Point>();
        
        queue.offer(new Point(startX, startY));
        
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            
            for (int i = 0; i < 4; i++) {
                int movedX = x + moveX[i];
                int movedY = y + moveY[i];
                
                if (movedX < 0 || movedY < 0 || movedX >= place.length || movedY >= place[0].length() || (movedX == startX && movedY == startY)) {
                    continue;
                }
                
                int menhathen = getMenhathen(startX, startY, movedX, movedY);
                
                String movedValue = String.valueOf(place[movedX].charAt(movedY));
                
                if (movedValue.equals("P") && menhathen <= 2) {
                    return false;
                }
                
                if (movedValue.equals("X")) {
                    continue;
                }
                
                if (menhathen >= 2) {
                    continue;
                }
                
                queue.offer(new Point(movedX, movedY));
            }
        }
        return true;
    }
    
    private int validateRoom(String[] place) {
        int result = 1;
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (String.valueOf(place[i].charAt(j)).equals("P")) {
                    if (!bfs(i, j, place)) {
                        result = 0;
                    }
                }
            }
        }
        
        return result;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            int result = validateRoom(places[i]);
            answer[i] = result;
        }
        
        return answer;
    }
}