package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_dfs {
 //dfs 는 재귀적 , stack
	//bfs는 Queue
	public static void main(String[] args) {
		
		char[][] grid = {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','1','1','1'},
				{'0','0','0','1','1'}};
		Basic_dfs a = new Basic_dfs();
		System.out.println(a.dfs(grid));
	}

	int m, n = 0;
	int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public int dfs(char[][]grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
		m = grid.length; // row
		n = grid[0].length; //col
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] =='1') {
					count++;
					dfs(grid,i,j);
					
				}
			}
		}
		
		return count;	
	}
	
	public void dfs(char[][] grid, int i, int j) {
		
		if(i<0 || j<0 || i>=m || j>=n || grid[i][j] !='1') return;  //해당 안되는것 걸러내기
		
		grid[i][j] = 'X';
		
		for(char[] a : grid) {
			System.out.println(a);
		}
		System.out.println("-------------------------------------");

		for(int[]dir : dirs) {
			dfs(grid, i+dir[0], j+dir[1]);
		}
		
	}
}























