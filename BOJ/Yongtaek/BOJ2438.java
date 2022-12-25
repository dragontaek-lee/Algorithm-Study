import java.util.Scanner;

public class BOJ2438 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;

        num = sc.nextInt();
        
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        sc.close();
    }
}