package Sort;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;

public class BOJ10814 {
    public static class Person {
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Person> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(arr, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }   
        });

        for(int i = 0; i < n ; i++) {
            sb.append(arr.get(i).age + " " + arr.get(i).name + "\n");
        }

        System.out.println(sb);
    }
}
