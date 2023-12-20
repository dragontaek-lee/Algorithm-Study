import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> carEntrance = new HashMap<>();
        HashMap<Integer, Integer> carTotalTime = new HashMap<>();
        SortedMap<Integer, Integer> bills = new TreeMap<>();
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int standardTime = fees[2];
        int standardFee = fees[3];
        
        for (int i = 0; i < records.length; i++) {
            String[] parkingData = records[i].split(" ");
            
            String[] timeSplit = parkingData[0].split(":");
         
            int time = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            int carNum = Integer.parseInt(parkingData[1]);
            String state = parkingData[2];
            
            if (state.equals("IN")) {
                carEntrance.put(carNum, time);   
            }
            
            if (state.equals("OUT")) {
                if (carTotalTime.get(carNum) == null) {
                    carTotalTime.put(carNum, time - carEntrance.get(carNum));
                } else {
                    carTotalTime.put(carNum, carTotalTime.get(carNum) + time - carEntrance.get(carNum));
                }
                carEntrance.remove(carNum);
            }
        }
        
        if (carEntrance.size() > 0) {
            for (int i : carEntrance.keySet()) {
                int entranceTime = carEntrance.get(i);
                int totalTime = 1439 - entranceTime;
                if (carTotalTime.get(i) == null) {
                    carTotalTime.put(i, totalTime);
                } else {
                    carTotalTime.put(i, carTotalTime.get(i) + totalTime);
                }
            }
        }
        
        for (int i: carTotalTime.keySet()) {
            int totalTime = carTotalTime.get(i);
            int payment = totalTime <= baseTime
                ? baseFee : baseFee + (int) Math.ceil((double)(totalTime - baseTime) / standardTime) * standardFee;
            bills.put(i, payment);
        }
        
        int[] answer = new int[bills.size()];
        
        int index = 0;
        for (int i : bills.keySet()) {
            answer[index] = bills.get(i);
            index++;
        }
        
        return answer;
    }
}