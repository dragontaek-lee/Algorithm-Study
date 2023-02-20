package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> array = new ArrayList<>();

        String num = br.readLine();

        for(int i = 0; i < num.length(); i++) {
            array.add(Character.getNumericValue(num.charAt(i)));
        }

        Collections.sort(array, Collections.reverseOrder());

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }
    }
}
