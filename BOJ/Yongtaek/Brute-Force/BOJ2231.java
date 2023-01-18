import java.util.Scanner;

public class BOJ2231 {
    static int n;
    static int min = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int sum = i;
            int tmp = i;
            while(tmp > 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }
            if(sum == n && min >= sum) min = i; 
        }

        if(min == 1000000) System.out.println(0);
        else System.out.println(min);
        sc.close();
    }
}
