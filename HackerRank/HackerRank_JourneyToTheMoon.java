package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
    * https://www.hackerrank.com/challenges/journey-to-the-moon/problem?h_r=profile
    * 주어진 메소드의 반환형을 바꿔줘야 할 수도 있다 (int로 주어졌는데 long으로 바꾸기)
    * 중복되는것 ((a,b) (b,a)) 세고 2로 나누거나, ((a,b))만 세거나 둘 중 한가지 방법
    * long 형 반환
*/

class Result {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int tempCount = 0;
    static ArrayList<Integer> groupNums = new ArrayList<>();
    static ArrayList<Integer> dp = new ArrayList<>();
    
    public static void dfs(int start) {
        visited[start] = true;
        tempCount++;
        
        for(int i: graph[start]) {
            if(visited[i]) continue;
            dfs(i);
        }
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i ++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }
        
        astronaut.stream().forEach(pair -> {
            int firstPerson = pair.get(0);
            int secondPerson = pair.get(1);
            graph[firstPerson].add(secondPerson);
            graph[secondPerson].add(firstPerson);
        });
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                groupNums.add(tempCount);
                tempCount = 0;
            }
        }
      
        long result = 0;
        for (int i = 0; i < groupNums.size(); i++) {
            result += ((n - groupNums.get(i)) * groupNums.get(i));
        }
        
        result /= 2;
    
        return result;
    }

}

public class HackerRank_JourneyToTheMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
