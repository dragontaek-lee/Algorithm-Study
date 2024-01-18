import java.util.*;

class Solution {
    private static Map<String, Integer> courseCount;
    private static Map<String, Integer> courseCountTemp;
    private static boolean[] visited;
    
    private void putCourse(Map<String, Integer> courseCountTemp) {
        ArrayList<String> courseKeyList = new ArrayList<>(courseCountTemp.keySet());
            
        for (int i = 0; i < courseKeyList.size(); i++) {
            String key = courseKeyList.get(i);
            Integer value = courseCountTemp.get(key);
            courseCount.put(key, courseCount.getOrDefault(key, 0) + 1);
        }    
    }
    
    private String sortString(String targetString) {
        char[] chars = targetString.toCharArray();
        Arrays.sort(chars);
        
        return String.valueOf(chars);
    }
    
    private void getCourseSet(String menu, String order, int length, int start) {
        if (menu.length() == length) {
            String course = sortString(menu);
            courseCountTemp.put(course, courseCountTemp.getOrDefault(course, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                getCourseSet(menu + order.charAt(i), order, length, i + 1);
                visited[i] = false;
            }
        }
    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++) {
            courseCount = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                courseCountTemp = new HashMap<>();
                String order = orders[j];
                visited = new boolean[order.length()];
                getCourseSet("", order, course[i], 0);
                putCourse(courseCountTemp);
            }
            
            int max = -1;
            for (String key : courseCount.keySet()) {
                max = Math.max(max, courseCount.get(key));
            }
      
            for (String key : courseCount.keySet()) {
                if (courseCount.get(key) >= 2)
                    if (max == courseCount.get(key)) {
                        answer.add(key);
                    }
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}