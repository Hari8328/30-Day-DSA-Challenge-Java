import java.util.*;
public class GraphValidTree {

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

    public static boolean validTree(
            int n,
            int[][] edges) {

        if (edges.length != n - 1)
            return false;

        UnionFind uf =
                new UnionFind(n);

        for (int[] edge : edges) {

            if (!uf.union(
                    edge[0],
                    edge[1])) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };

        System.out.println(
                validTree(5, edges)
        );
    }
}
