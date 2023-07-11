package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
    https://www.hackerrank.com/challenges/torque-and-development/problem?isFullScreen=true
    long형 cast에 신경쓰기
*/

class Result {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static long countCities = 0;
    static long countRoads = 0;

    public static void dfs(int start) {
        visited[start] = true;
        
        for (int i : graph[start]) {
            if (visited[i]) {
                continue;
            }
            countRoads++;
            dfs(i);
        }
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        countCities = 0;
        countRoads = 0;
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
            graph[i] = new ArrayList<Integer>();
        }
        
        cities.stream().forEach(city -> {
            int firstCity = city.get(0);
            int secondCity = city.get(1);
            
            graph[firstCity].add(secondCity);
            graph[secondCity].add(firstCity);
        });
        
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                countCities++;
            }
        }
        
        long libraryPrice = countCities * c_lib; 
        long roadPrice = countRoads * c_road;
        long totalPrice = libraryPrice + roadPrice;
        
        long allLibraryPrice = (long)n * c_lib;
        
        if (totalPrice >= allLibraryPrice) {
            return allLibraryPrice;
        }
        
        return totalPrice;
    }

}

public class GraphTheory {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
