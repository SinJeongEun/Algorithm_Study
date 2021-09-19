package bfs_dfs;

public class Dfs_memoization {
	// 정수이고, matrix내에서 값이 증가하면서 가장 긴 경우의 경로를 반환하세요
//	각 셀에서 사방(왼쪽, 오른쪽, 윗쪽, 아래쪽)으로 할 수 있습니다.
//	값이 같은 경우는 제외합니다.
	public static void main(String[] args) {
		int[][] grid = {
				{9, 8, 3},
				{6, 5, 7},
				{2, 1, 1}};
		Dfs_memoization a = new Dfs_memoization();
		System.out.println(a.solve(grid));
	}
	
	public static final int[][] dirs =  {{1,0},{-1,0},{0,1},{0,-1}};
	
	public int solve(int[][] matrix) {
		if(matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int max =1;
		int [][] result = new int [m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int len = dfs(matrix, i, j, m, n, result);
				max = Math.max(max, len);
			}
			
		}
		for(int[]a : result) {
			for(int b : a) {
				System.out.print(b);
			}
		}
		System.out.println();
		return max;
	}
	
	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][]result) {
		if(result[i][j] != 0) return result[i][j];
		int max = 1;
		for(int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if(x < 0 || x >=m || y<0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
			
			System.out.println("x: " + x + " y: " + y);
			System.out.println(result[x][y]);
			int len = 1 + dfs(matrix, x, y, m, n, result);
			max = Math.max(max, len);			
		}
		result[i][j] = max;
		return max;
	}

}
