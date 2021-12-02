package dynamic_programming;

public class HouseRobber {

	//������ �� ���� ħ���ϸ� ������ �ڵ����� ������
	//������ �ɸ��� �ʰ� ������ �� �� �ִ� �ִ� �ݾ� ���ϱ�
	
	//dp�� �̹� ���� �� ������ ��Ģ�� ã�´�
	//0,1,2 �����ϰ� �� �������� �ݺ����� �ǹ̰� ����
	
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
