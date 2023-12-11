import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();
    
        int idx = 1;
        for (int i = 65; i < 91; i++) {
            dictionary.put(Character.toString((char)i), idx);
            idx++;
        }
        
        for(int i = 0; i < msg.length(); i++) {
			String key = msg.charAt(i) + "";
			int index = i + 1;

			while(index <= msg.length()) {
				if(index == msg.length()) {
					list.add(dictionary.get(msg.substring(i)));
					i = index;
					break;
				}

				String nextKey = msg.substring(i, index+1);

				if(dictionary.containsKey(nextKey)) { 
					index++;
				} else { 
					key = msg.substring(i, index);
					list.add(dictionary.get(key)); 
					dictionary.put(nextKey, dictionary.size()+1); 
					i = index - 1;
					break;
				}
			}
		}

		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}