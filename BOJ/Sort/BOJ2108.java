package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class BOJ2108 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> modeList = new ArrayList<>();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] =  Integer.parseInt(br.readLine());
        }
        
        int max = Arrays.stream(arr).max().getAsInt();

        int count[] = new int[max + 4001];
        
        for(int j = 0; j < arr.length; j++) {
            int idx = arr[j] + 4000;
            count[idx] += 1;
        }

        int countMax = Arrays.stream(count).max().getAsInt();

        int sum = 0;
        int start = 0;
        int end = 0;
        int center = 0;
        int cnt = 0;

        for(int i = 0; i < count.length; i++) {
            int real = i - 4000;
            for(int j = 0; j < count[i]; j++) {
                sum += real;

                if(cnt == Math.round(n/2)) center = real;
                if(cnt == 0) start = real;
                if(cnt == n-1) end = real;

                cnt++;
            }
            if(count[i] == countMax) modeList.add(real);
        }

        int mode = 0;
        if(modeList.size() > 1) mode = modeList.get(1);
        else mode = modeList.get(0);

        System.out.println((int)Math.round((double)sum/n));
        System.out.println(center);
        System.out.println(mode);
        System.out.println(end-start);
    }
}
