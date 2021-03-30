package Array;

public class Array1 {

	public static void main(String[] args) {
		int nums[] = {8,2,6,5,1,7,5 };
		System.out.println(new Array1().maxProfit(nums));

	}
	
	public int maxProfit(int nums[]) {
		if(nums.length ==0) return 0;
		
		int max =0;
		int sofaMin = nums[0];
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i] < sofaMin) {
				sofaMin = nums[i];
			}
			else {
				max = Math.max(max,nums[i]-sofaMin);
			}
		}
		return max;
	}

}
