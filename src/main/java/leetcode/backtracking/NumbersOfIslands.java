package leetcode.backtracking;

/**
 * leetcode#200
 *
 * @author haze
 * @date created at 2020/5/31 3:04 下午
 */
public class NumbersOfIslands {

    private int xSize, ySize;
    /**
     * 移动辅助计算数组 2列4行 m=2 n=4
     * 当i=0,d[0][0]=0 ,d[0][1]=1  ->(x+0,y+1) 向下
     * 当i=1,d[1][0]=1 ,d[1][1]=0  ->(x+1,y+0) 向右
     * 当i=2,d[2][0]=0 ,d[2][1]=-1 ->(x+0,y-1) 向上
     * 当i=3,d[3][0]=-1,d[3][1]=0  ->(x-1,y+0) 向左
     */
    private static final int[][] d = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    private boolean[][] visited;

    /**
     * 陆地='1'
     * 水面='0'
     */
    private static final char LAND = '1';


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        ySize = grid.length;
        xSize = grid[0].length;

        visited = new boolean[ySize][xSize];
        int res = 0;

        for (int y = 0; y < ySize; y++) {

            for (int x = 0; x < xSize; x++) {
                if (
                        grid[y][x] == LAND
                                && !visited[y][x]
                ) {
                    dfs(grid, y, x);
                    res++;
                }

            }

        }
        return res;
    }

    private void dfs(char[][] grid, int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + d[i][0];
            int newX = x + d[i][1];
            if (
                    withinBoundary(newY, newX)
                            && !visited[newY][newX]
                            && grid[newY][newX] == LAND
            ) {
                dfs(grid, newY, newX);
            }
        }
    }

    private boolean withinBoundary(int y, int x) {
        return y >= 0 && x >= 0
                && y < ySize && x < xSize;
    }

    public static void main(String[] args) {
        System.out.println(
                d[2][0]
        );
        char[][] grid1 = {
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1'},
                {'1', '0', '1', '0', '0'},
                {'1', '1', '0', '0', '0'}
        };
        System.out.println((new NumbersOfIslands()).numIslands(grid1));
        // 1

        // ---

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new NumbersOfIslands()).numIslands(grid2));
        // 3
    }
}
