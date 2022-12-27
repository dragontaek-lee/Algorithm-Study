import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1427 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();

        int temp = n;
        while(temp > 0) {
            list.add(temp % 10);
            temp /= 10;
        }

        list.sort(Comparator.reverseOrder());

        list.forEach(x-> System.out.print(x));

        sc.close();
    }
}
