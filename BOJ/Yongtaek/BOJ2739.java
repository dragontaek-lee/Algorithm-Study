import java.util.Scanner;

public class BOJ2739 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num;
        num = sc.nextInt();

        for(int i = 1; i < 10; i++){
            sb.append(num + " * " + i + " = " + num * i);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
