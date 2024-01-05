import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nickname = new HashMap<>();
        
        int resultLength = 0;
        for (int i = 0; i < record.length; i++) {
            String[] infos = record[i].split(" ");
            String action = infos[0];
            String uid = infos[1];
            String nickName = infos.length > 2 ? infos[2] : null;
            
            if (action.equals("Enter") || action.equals("Change")) {
                nickname.put(uid, nickName);
            }
            
            if (!action.equals("Change")) {
                resultLength++;
            }
        }
        
        String[] answer = new String[resultLength];
        
        int currentIdx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] infos = record[i].split(" ");
            String action = infos[0];
            String uid = infos[1];
            String nickName = infos.length > 2 ? infos[2] : null;
            
            if (!action.equals("Change")) {
                String accessString = action.equals("Enter") ? "들어왔습니다." : "나갔습니다.";
                answer[currentIdx] = nickname.get(uid) +"님이 " + accessString;
                currentIdx++;    
            }
        }      
        
        return answer;
    }
}