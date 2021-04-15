package Array_2D;

import java.util.HashSet;
import java.util.Set;

public class MatrixZero {

	public static void main(String[] args) {
		int grid[][] = { {1,1,1},
					     {1,0,1},
					     {1,1,1}};
		new MatrixZero().solve(grid);
	}
	
	public void solve(int[][]grid) {
		
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		
		//0이 들어있는 좌표값 저장
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		
		//해당 하는 부분 0으로 만들기		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(rowSet.contains(i) || colSet.contains(j)) {
					grid[i][j]=0;
				}
			}
		}
		
		
		
		print(grid);
	}
	
	public void print(int[][]grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print("["+i+"]["+ j +"] " +grid[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
