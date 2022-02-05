package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumMap {

	public static void main(String[] args) {
		int nums[] = {3, 4, 7, 2, -3, 1, 4, 2};
		int k=7;
		System.out.println(solve(nums,k));

	}
	
	public static int solve(int[]nums ,int k) {
		int count=0;
		int sum = 0;
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, 1); //시작 점을 만든다 ** map의 key가 배열의 합이자,sum-7의 값의 key가 있어야 sub배열의 합이 7임이 증몀됨 -> count++
											// 0인 key가 있어야 gndp 7-7 일 때도 count++이 가능해 짐 
		
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			if(sum-k == 7) count += map.get(sum-k);
			System.out.println(map + " " + count);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}	
		return count;		
	}
}
