package Sort;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            sorted.add(num);
        }

        sorted.sort(null);

        int count = 0;
        for(int val : sorted) {
            if(!map.containsKey(val)) {
                map.put(val, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int val: arr) {
            sb.append(map.get(val)+" ");
        }

        System.out.println(sb);
    }
}
