import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String formattedStr1 = str1.toLowerCase();
        String formattedStr2 = str2.toLowerCase();
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
        for (int i = 0; i < formattedStr1.length()-1; i++) {
            String str = formattedStr1.substring(i, i+2);
            boolean isValid = true;
            for (int j = 0; j < str.length(); j++) {
                if (!Character.isLetter(str.charAt(j))) {
                    isValid = false;
                }
            }
            
            if (isValid) {
                str1List.add(str);
            }
        }
        
        for (int i = 0; i < formattedStr2.length()-1; i++) {
            String str = formattedStr2.substring(i, i+2);
            boolean isValid = true;
            for (int j = 0; j < str.length(); j++) {
                if (!Character.isLetter(str.charAt(j))) {
                    isValid = false;
                }
            }
            
            if (isValid) {
                str2List.add(str);
            }
        }
        
        int intersection = 0;
        int union = 0;
        List<String> str2ListCopy = new ArrayList<>(str2List);
        for (int i = 0; i < str1List.size(); i++) {
            String str1Str = str1List.get(i);
            List<String> str2ListTemp = new ArrayList<>(str2ListCopy);
            for (int j = 0; j < str2ListTemp.size(); j++) {
                if (str1Str.equals(str2ListTemp.get(j))) {
                    intersection++;
                    str2ListCopy.remove(str2ListTemp.get(j));
                    break;
                }
            }
        }
        
        union = str1List.size() + str2List.size() - intersection;
        
        
        if (union == 0 && intersection == 0) {
            return 65536;
        }
        
        return (int)((double)intersection / (str1List.size() + str2List.size() - intersection) * 65536.00);
    }
}