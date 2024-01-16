class Solution {
  public String solution(int n) {
      String[] numbers = {"4", "1", "2"};
      String answer = "";
      
      int currentNum = n;
      
      while (currentNum > 0){
          int remain = currentNum % 3;
          currentNum /= 3;
          
          if (remain == 0) {
              currentNum--;
          }
          
          answer = numbers[remain] + answer;
      }
      
      return answer;
  }
}