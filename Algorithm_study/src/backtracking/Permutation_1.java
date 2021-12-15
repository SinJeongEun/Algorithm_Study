package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_1 {

	public static void main(String[] args) {
		// {1,2,3}인 경우 만들 수 있는 조합의 수 (순서 고려o, nPr)
		int[] nums = {1,2,3};
		System.out.println(new Permutation_1().solve(nums));
	}
	
	public List<List<Integer>> solve(int[]nums){
		 List<List<Integer>> result = new ArrayList<>();
		 List<Integer> tempList = new ArrayList<>();
		 backtrack(result,tempList,nums);
		 return result;
	}
	
	public void backtrack(List<List<Integer>> result,List<Integer> tempList, int[]nums) {
		if(tempList.size() == nums.length) {
			System.out.println(tempList);
			result.add(new ArrayList<>(tempList));
		}else {
			for(int i=0;i<nums.length;i++) {
				if(tempList.contains(nums[i])) continue;
				tempList.add(nums[i]);
				backtrack(result,tempList,nums);
				tempList.remove(tempList.size()-1);
			}			
		}	
	}	
}
