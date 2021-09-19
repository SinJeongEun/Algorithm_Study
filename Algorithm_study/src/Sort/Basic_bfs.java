package Sort;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_bfs {

	public static void main(String[] args) {
		
		char[][] grid = {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'0','0','0','1','1'}};
		Basic_bfs a = new Basic_bfs();
		System.out.println(a.bfs(grid));
	}

	int m, n = 0;
	int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public int bfs(char[][]grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
		m = grid.length; // row
		n = grid[0].length; //col
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] =='1') {
					count++;
					bfs(grid,i,j);
					
				}
			}
		}
		return count;	
	}
	
	public void bfs(char[][] grid, int x, int y) {
		grid[x][y] = 'X'; // visited 의미
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y}); //0,0을 큐에 삽입
		
	
		while(!queue.isEmpty()) {
			int [] point = queue.poll();
			
			for(int[]dir : dirs) {
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];
				
				if(x1>=0 && y1>=0 && m>x1 && n>y1 && grid[x1][y1] =='1') {
					grid[x1][y1] = 'X';
					queue.offer(new int[] {x1, y1});
					for(char[] a : grid) {
						System.out.println(a);
					}
					System.out.println("--------------------------------");
				}
			}
		}
		
	}
}
