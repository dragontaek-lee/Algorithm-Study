import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ10814 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Person arr[] = new Person[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });

        for(int i = 0; i < n ; i++) {
            sb.append(arr[i].age + " " + arr[i].name + "\n");
        }

        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
