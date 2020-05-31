package leetcode.backtracking;

import datastructure.tree.UnionFind;

import java.util.HashSet;

/**
 * leetcode#200
 * 使用并查集解决
 *
 * @author haze
 * @date created at 2020/5/31 3:04 下午
 * @see datastructure.tree.UnionFind
 */
public class NumbersOfIslands2 {
    private int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int newX = i + d[k][0], newY = j + d[k][1];
                        if (inArea(newX, newY) && grid[newX][newY] == '1') {
                            uf.unionElements(i * n + j, newX * n + newY);
                        }
                    }
                }
            }
        }
        HashSet<Integer> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands.add(uf.find(i * n + j));
                }
            }
        }
        return islands.size();
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new NumbersOfIslands2()).numIslands(grid1));
        // 1

        // ---

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new NumbersOfIslands2()).numIslands(grid2));
        // 3
    }
}
