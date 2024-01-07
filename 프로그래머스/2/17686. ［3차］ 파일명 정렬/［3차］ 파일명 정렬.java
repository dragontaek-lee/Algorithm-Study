import java.util.*;

class Solution {
    public static int index = 0;
    public static String[][] fileInfos;
    
    private String getFileHead(String fileName) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileName.length(); i++) {
            Character ch = fileName.charAt(i);
            if (!Character.isDigit(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                index = i;
                break;
            }
        }
        
        return sb.toString();
    }
    
    private String getFileNumber(String fileName) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < fileName.length(); i++) {
            Character ch = fileName.charAt(i);
            if (Character.isDigit(ch) && i - index < 5) {
                sb.append(ch);
            } else {
                index = i;
                break;
            }
        }
        
        return Integer.toString(Integer.parseInt(sb.toString()));
    }
    
    private String getFileTail(String fileName) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < fileName.length(); i++) {
            Character ch = fileName.charAt(i);
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        // fileName HEAD NUMBER TAIL
        fileInfos = new String[files.length][5];
        
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            fileInfos[i][0] = fileName;
            fileInfos[i][1] = getFileHead(fileName);
            fileInfos[i][2] = getFileNumber(fileName);
            fileInfos[i][3] = getFileTail(fileName);
            fileInfos[i][4] = Integer.toString(i);
            index = 0;
        }
        
        Arrays.sort(fileInfos, (arr1, arr2) -> {
           if (!(arr1[1].equals(arr2[1]))) {
               return arr1[1].compareTo(arr2[1]);
           } else {
               if (Integer.parseInt(arr1[2]) != Integer.parseInt(arr2[2])) {
                   return Integer.parseInt(arr1[2]) - Integer.parseInt(arr2[2]);
               } else {
                   return Integer.parseInt(arr1[4]) - Integer.parseInt(arr2[4]);
               }
           }
        });
                
        for (int i = 0; i < files.length; i++) {
           answer[i] = fileInfos[i][0];
        }
        
        return answer;
    }
}