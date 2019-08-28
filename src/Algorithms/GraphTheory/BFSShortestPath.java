package Algorithms.GraphTheory;

import java.util.*;

public class BFSShortestPath {

    public static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int q = in.nextInt();//number of queries

        for (int a0 = 0; a0 < q; a0++) {

            int n = in.nextInt();// number of vertices
            adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());// graph, so used lis<list<integer>>
            }

            int m = in.nextInt();// number of edges
            for (int a1 = 0; a1 < m; a1++) {
                // connections
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int s = in.nextInt() - 1;// start vertex

            ArrayList<Integer> result = bfs(adj, s);

            for (int i = 0; i < n; i++) {// to display in required format
                if (i != s) {
                    if (result.get(i) == 0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(result.get(i) + " ");
                    }
                }
            }
            System.out.print("\n");
        }
        in.close();
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s) {

        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            result.add(0);
        }
        q.addFirst(s);// add the start vertex

        while (q.size() > 0) {

            int current = q.pollLast();// extracts the last element in the list

            ArrayList<Integer> list = adj.get(current);// neighbours extracted

            for (int i = 0; i < list.size(); i++) {
                // add neighbours to the list and set the values
                int v = list.get(i);
                if (result.get(v) == 0) {
                    q.addFirst(v);
                    result.set(v, result.get(current) + 6);
                }
            }
        }

        return result;
    }

}
