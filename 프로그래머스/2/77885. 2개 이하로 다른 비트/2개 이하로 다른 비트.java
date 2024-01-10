class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bitNum = Long.toString(numbers[i], 2);
            
            String convertedBitNum = "0" + bitNum;
            
            StringBuilder sb = new StringBuilder();
            sb.append(convertedBitNum);
            
            int zeroIndex = -1;
            int oneIndex = -1;
            
            for (int j = convertedBitNum.length() - 1; j >= 0; j--) {
                if (convertedBitNum.charAt(j) == '0') {
                    zeroIndex = j;
                    break;
                }
            }
            
             for (int j = zeroIndex + 1; j < convertedBitNum.length(); j++) {
                if (convertedBitNum.charAt(j) == '1') {
                    oneIndex = j;
                    break;
                }
            }
            
            if (zeroIndex != -1) {
                sb.setCharAt(zeroIndex, '1');
            }
            
            if (oneIndex != -1) {
                sb.setCharAt(oneIndex, '0');
            }
            
            answer[i] = Long.parseLong(sb.toString(), 2);
            
        }
        return answer;
    }
}