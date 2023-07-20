import java.util.Scanner;

public class BOJ1436 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        int res = 0;
        int num = 1;
        while(true){
            int tmp = num;

            int sixCount = 0;
            boolean isSeqSix = false;
            while(tmp > 0) {
                int digit = tmp % 10;

                if(digit == 6) {
                    sixCount++;
                } else {
                    sixCount = 0;
                }

                if(sixCount == 3) isSeqSix = true;

                tmp /= 10;
            }

            if(isSeqSix) count++;

            if(count == n) {
                res = num;
                break;
            }

            num++;
        }

        System.out.println(res);

        sc.close();
    }
    
}
