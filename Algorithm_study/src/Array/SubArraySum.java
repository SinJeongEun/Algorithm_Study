package Array;

public class SubArraySum {

	public static void main(String[] args) {
		int nums[] = {3, 4, 7, 2, -3, 1, 4, 2};
		int k=7;
		System.out.println(solve(nums,k));

	}
	
	public static int solve(int[]nums ,int k) {
		int count=0;
		for(int i=0;i<nums.length;i++) {
			int sum=0;
			int a =0;
			for(int j=i;j<nums.length;j++) {
				a++;
				sum += nums[j];
				if(sum==k) count++;
			}
		}
		return count;		
	}
}
