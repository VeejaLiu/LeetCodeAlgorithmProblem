package com.veeja.leetCode.poj;


import java.util.Scanner;

/**
 * @Author veeja
 * 2021/3/8 14:31
 */
@SuppressWarnings("ALL")
public class Q2386 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m, n;
        m = scanner.nextInt();
        System.out.println(m);
        n = scanner.nextInt();
        System.out.println(n);
        scanner.nextLine();


        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = String.valueOf(s.charAt(j));
            }
        }

//        printArray(grid);

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(".")) {
                    continue;
                }
                // 如果找到一个陆地方块，就令结果+1，并将所有的邻接陆地修改为水。
                result++;
                dfsSearch(grid, i, j);
            }
        }

        System.out.println(result);

    }

    public static void dfsSearch(String[][] grid, int i, int j) {

        grid[i][j] = ".";

        printArray(grid);
        // 向左搜索
        if (j - 1 >= 0) {
            if (grid[i][j - 1].equals("W")) {
                dfsSearch(grid, i, j - 1);
            }
        }
        // 向上搜索
        if (i - 1 >= 0) {
            if (grid[i - 1][j].equals("W")) {
                dfsSearch(grid, i - 1, j);
            }
        }
        // 向右搜索
        if (j + 1 <= grid[i].length - 1) {
            if (grid[i][j + 1].equals("W")) {
                dfsSearch(grid, i, j + 1);
            }
        }
        // 向下搜索
        if (i + 1 <= grid.length - 1) {
            if (grid[i + 1][j].equals("W")) {
                dfsSearch(grid, i + 1, j);
            }
        }

        // 向左上搜索
        if (j - 1 >= 0 && i - 1 >= 0) {
            if (grid[i - 1][j - 1].equals("W")) {
                dfsSearch(grid, i - 1, j - 1);
            }
        }
        // 向右上搜索
        if (j + 1 <= grid[i].length - 1 && i - 1 >= 0) {
            if (grid[i - 1][j + 1].equals("W")) {
                dfsSearch(grid, i - 1, j + 1);
            }
        }
        // 向左下搜索
        if (j - 1 >= 0 && i + 1 <= grid.length - 1) {
            if (grid[i + 1][j - 1].equals("W")) {
                dfsSearch(grid, i + 1, j - 1);
            }
        }
        // 向右下搜索
        if (j + 1 <= grid[i].length - 1 && i + 1 <= grid.length - 1) {
            if (grid[i + 1][j + 1].equals("W")) {
                dfsSearch(grid, i + 1, j + 1);
            }
        }
    }

    public static void printArray(String[][] grid) {
        System.out.println("------------------");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
}
