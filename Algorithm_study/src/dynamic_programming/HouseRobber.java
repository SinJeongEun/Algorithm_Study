package dynamic_programming;

public class HouseRobber {

	//인접한 두 집에 침입하면 경찰에 자동으로 연락됨
	//경찰에 걸리지 않고 도둑질 할 수 있는 최대 금액 구하기
	
	//dp는 이미 세팅 된 값에서 규칙을 찾는다
	//0,1,2 세팅하고 그 다음부터 반복문에 의미가 있음
	
	//dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
	public static void main(String[] args) {
		int nums[] = {2, 7, 9, 3, 1, 8};
		HouseRobber a = new HouseRobber();
		System.out.println(a.solve(nums));
	}
	
	public int solve(int[]nums) {
		if(nums.length == 0) return 0;
		
		int dp[] = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 7;
		
		for(int i=2;i<nums.length;i++) {
			dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
		}
		
		for(int i : dp) System.out.println(i);
		return dp[nums.length];
	}

}
