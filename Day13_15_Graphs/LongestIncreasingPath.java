import java.util.*;
public class LongestIncreasingPath {

    private static int[][] memo;

    private static final int[][] DIRS = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static int longestIncreasingPath(
            int[][] matrix) {

        if (matrix == null
                || matrix.length == 0)
            return 0;

        int rows =
                matrix.length;

        int cols =
                matrix[0].length;

        memo =
                new int[rows][cols];

        int max = 0;

        for (int i = 0;
             i < rows;
             i++) {

            for (int j = 0;
                 j < cols;
                 j++) {

                max =
                        Math.max(
                                max,
                                dfs(
                                        matrix,
                                        i,
                                        j
                                )
                        );
            }
        }

        return max;
    }

    private static int dfs(
            int[][] matrix,
            int row,
            int col) {

        if (memo[row][col]
                != 0) {

            return memo[row][col];
        }

        int longest = 1;

        for (int[] dir : DIRS) {

            int nr =
                    row + dir[0];

            int nc =
                    col + dir[1];

            if (nr >= 0
                    &&
                    nr < matrix.length
                    &&
                    nc >= 0
                    &&
                    nc < matrix[0].length
                    &&
                    matrix[nr][nc]
                            >
                            matrix[row][col]) {

                longest =
                        Math.max(
                                longest,
                                1 +
                                        dfs(
                                                matrix,
                                                nr,
                                                nc
                                        )
                        );
            }
        }

        memo[row][col] =
                longest;

        return longest;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        System.out.println(
                longestIncreasingPath(
                        matrix
                )
        );
    }
}
