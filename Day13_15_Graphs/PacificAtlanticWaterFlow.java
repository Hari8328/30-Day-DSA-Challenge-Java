import java.util.*;

public class PacificAtlanticWaterFlow {

    public static List<List<Integer>>
    pacificAtlantic(
            int[][] heights) {

        List<List<Integer>> result =
                new ArrayList<>();

        if (heights == null ||
                heights.length == 0)
            return result;

        int rows =
                heights.length;

        int cols =
                heights[0].length;

        boolean[][] pacific =
                new boolean[rows][cols];

        boolean[][] atlantic =
                new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            dfs(
                    heights,
                    pacific,
                    i,
                    0,
                    Integer.MIN_VALUE
            );

            dfs(
                    heights,
                    atlantic,
                    i,
                    cols - 1,
                    Integer.MIN_VALUE
            );
        }

        for (int j = 0; j < cols; j++) {

            dfs(
                    heights,
                    pacific,
                    0,
                    j,
                    Integer.MIN_VALUE
            );

            dfs(
                    heights,
                    atlantic,
                    rows - 1,
                    j,
                    Integer.MIN_VALUE
            );
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (pacific[i][j] &&
                        atlantic[i][j]) {

                    result.add(
                            Arrays.asList(
                                    i,
                                    j
                            )
                    );
                }
            }
        }

        return result;
    }

    private static void dfs(
            int[][] heights,
            boolean[][] ocean,
            int row,
            int col,
            int prevHeight) {

        if (row < 0 ||
                col < 0 ||
                row >= heights.length ||
                col >= heights[0].length ||
                ocean[row][col] ||
                heights[row][col] <
                        prevHeight) {

            return;
        }

        ocean[row][col] =
                true;

        dfs(
                heights,
                ocean,
                row + 1,
                col,
                heights[row][col]
        );

        dfs(
                heights,
                ocean,
                row - 1,
                col,
                heights[row][col]
        );

        dfs(
                heights,
                ocean,
                row,
                col + 1,
                heights[row][col]
        );

        dfs(
                heights,
                ocean,
                row,
                col - 1,
                heights[row][col]
        );
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        System.out.println(
                pacificAtlantic(
                        heights
                )
        );
    }
}
