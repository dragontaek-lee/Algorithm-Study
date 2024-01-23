import java.util.*;

class Solution {
    private static String[][] map;
    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int sum = 0;
    
    private void initMap(String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                String value = String.valueOf(maps[i].charAt(j));
                map[i][j] = value;
            }
        }
    }
    
    private void dfs(int x, int y) {
        map[x][y] = "X";
        
        for (int i = 0; i < 4; i++) {
            int movedX = x + moveX[i];
            int movedY = y + moveY[i];
            if (movedX < 0 || movedY < 0 || movedX >= map.length || movedY >= map[0].length) {
                continue;
            }
            
            if (map[movedX][movedY].equals("X")) {
                continue;
            }
            
            sum += Integer.parseInt(map[movedX][movedY]);
            dfs(movedX, movedY);
        }
    }
    
    public ArrayList<Integer> solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> answer = new ArrayList<>();
        
        initMap(maps);
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j].equals("X")) {
                    sum = Integer.parseInt(map[i][j]);
                    dfs(i, j);
                    answer.add(sum);
                }
            }
        }
        
        Collections.sort(answer);
        
        if (answer.size() == 0) {
            answer.add(-1);
        }
        
        return answer;
    }
}