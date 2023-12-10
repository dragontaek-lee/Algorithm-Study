import java.math.BigInteger;

class Solution {
     public static boolean isPrime(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(number.sqrt()) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.remainder(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String nDigit = Integer.toString(n, k);

        String[] splitNdigit = nDigit.split("0");
        
        for (int i = 0; i < splitNdigit.length; i++) {
            if (splitNdigit[i].isEmpty()) {
                continue;
            }
            BigInteger number = new BigInteger(splitNdigit[i]);
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }
}