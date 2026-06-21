import java.util.*;
public class NumberOfConnectedComponents {

    static class UnionFind {

        int[] parent;

        UnionFind(int n) {

            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB)
                return false;

            parent[rootA] = rootB;

            return true;
        }
    }

    public static int countComponents(
            int n,
            int[][] edges) {

        UnionFind uf =
                new UnionFind(n);

        int components = n;

        for (int[] edge : edges) {

            if (uf.union(edge[0],
                    edge[1])) {

                components--;
            }
        }

        return components;
    }

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(
                countComponents(5, edges)
        );
    }
}
