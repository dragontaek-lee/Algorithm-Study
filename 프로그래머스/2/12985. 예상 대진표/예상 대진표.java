class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        int orderA = a;
        int orderB = b;
        
        while (orderA != orderB) {
            orderA = (int) Math.ceil(((double) orderA / 2));
            orderB = (int) Math.ceil(((double) orderB / 2));        
            
            answer++;
        }

        return answer;
    }
}