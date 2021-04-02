package Array_2D;

import java.util.ArrayList;
import java.util.List;

public class Convert_2DArray_List {

	public static void main(String[] args) throws Exception {

		int A[][] = { {1,2,3} ,
					  {4,5,6,10,11},
					  {7,8,9,20} };
		
		//1. 2dAray -> list
		List<List<Integer>> list = convert(A);
		System.out.println(list);
		
		//2. list -> 2dArray
		System.out.println("======array call=======");
		int [][] arr2 = convert2(list);
		print(arr2);
		
	}
		//1. 2dArray -> list
		public static List<List<Integer>> convert(int[][]a){
			List<List<Integer>> result = new ArrayList<>();
			
			for(int i=0;i<a.length;i++) {
				List<Integer> list2 = new ArrayList<>();
				for(int j=0;j<a[i].length;j++) {
					list2.add(a[i][j]);
				}
				result.add(list2);
			}
			return result;
		}
		
		//2. list -> 2dArray
		public static int[][] convert2(List<List<Integer>> list){
			int[][] result = new int[list.size()][];  //3행
			
			//1. 배열의 구조 먼저 생성해야됨**
			for(int i=0;i<result.length;i++) {
				result[i] = new int[list.get(i).size()];  // column 길이 설정
			}
			
			//2. 값  넣기
			for(int i=0;i<list.size();i++) {
				for(int j=0;j<list.get(i).size();j++) {
					result[i][j] = list.get(i).get(j);
				}
			}
			
			return result;
		}
		
		public static void print(int[][]arr2) {
			for(int i=0;i<arr2.length;i++) {
				for(int j=0;j<arr2[i].length;j++) {
					System.out.print("[a"+i+"]["+j+"]"+arr2[i][j]);
				}
				System.out.println("");
			}
		}
		
		
	}

