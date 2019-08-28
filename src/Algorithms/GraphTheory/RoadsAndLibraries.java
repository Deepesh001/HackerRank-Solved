package Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {

        private static List<List<Integer>> adj;// to make a connected graph with possible cycles and various neighbours
        private static boolean[] visited;// to mark if any vertex is visited to avoid visiting it again
        private static int count;

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int q = in.nextInt();// number of queries

            for (int a0 = 0; a0 < q; a0++) {
                int n = in.nextInt();// number of cities

                adj = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    adj.add(new ArrayList<>()); // filling each adj entry with an empty ArrayList
                }

                visited = new boolean[n];// to avoid going in loops

                int m = in.nextInt();// number of roads
                int x = in.nextInt();// cost to repair a library
                int y = in.nextInt();// cost to repair a road

                for (int a1 = 0; a1 < m; a1++) {// for connecting the graph as per user input
                    int city_1 = in.nextInt();
                    int city_2 = in.nextInt();
                    adj.get(city_1 - 1).add(city_2 - 1);
                    adj.get(city_2 - 1).add(city_1 - 1);
                }

                System.out.println(roadsAndLibraries(x, y));
            }

            in.close();
        }

        private static long roadsAndLibraries(int x, int y) {
            long cost = 0;

            for (int i = 0; i < adj.size(); i++) {
                if (!visited[i]) {
                    count = 0;
                    dfs(i);
                    if (x > y) {
                        cost += x + y * (count - 1);
                    } else {
                        cost += x * count;
                    }
                }
            }

            return cost;
        }


// count number of cities (elements) in each connected component
    private static void dfs(int i) {
            visited[i] = true;
            count++;

            List<Integer> list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (!visited[list.get(j)]) {
                    dfs(list.get(j));
                }
            }
        }
    }
