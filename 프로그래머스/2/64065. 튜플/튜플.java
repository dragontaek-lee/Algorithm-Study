import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<List<Integer>> tupleList = new ArrayList<>();
        
        String covertedString = s.substring(1, s.length() - 1).replace("},{","-");
        String tuplesString = covertedString.substring(1, covertedString.length() - 1);
    
        String[] tuples = tuplesString.split("-");
        for (int i = 0; i < tuples.length; i++) {
            String[] numbers = tuples[i].split(",");
            
            List<Integer> nums = new ArrayList<>();
            for(int j = 0; j < numbers.length; j++) {
                nums.add(Integer.parseInt(numbers[j]));
            }
            tupleList.add(nums);
        }
        
        Collections.sort(tupleList, (a,b) -> {
            return a.size() - b.size();
        });
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < tupleList.size(); i++) {
            List<Integer> tupleSet = tupleList.get(i);  
            for (int j = 0; j < tupleSet.size(); j++) {
                if (!answer.contains(tupleSet.get(j))) {
                    answer.add(tupleSet.get(j));
                }
            }
        }

        return answer;
    }
}