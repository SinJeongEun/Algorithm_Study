package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_1 {

	public static void main(String[] args) {
		// (а╤гу, nCr)
		int nums = 3;
		final int k = 2;
		System.out.println(new Combination_1().solve(nums,k));
	}
	
	public List<List<Integer>> solve(int nums,int k){
		 List<List<Integer>> result = new ArrayList<>();
		 List<Integer> tempList = new ArrayList<>();
		 backtrack(result,tempList,nums,k,1);
		 return result;
	}
	
	public void backtrack(List<List<Integer>> result,List<Integer> tempList, int nums,int k, int start) {
		if(tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
		}else {
			for(int i=start; i<=nums;i++) {
				tempList.add(i);
//				System.out.println(tempList);
				backtrack(result,tempList,nums,k,i+1);
//				System.out.println("========================================");
				tempList.remove(tempList.size()-1);
//				System.out.println("---->" + tempList);

			}			
		}	
	}	
}