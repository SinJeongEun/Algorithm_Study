package dynamic_programming;

public class DecodeWays {

	public static void main(String[] args) {
		// 주어진 숫자를 알팢벳으로 디코딩 한다.
//		String s ="12";
		String s ="121";
//		String s ="1211";

		DecodeWays a = new DecodeWays();
		System.out.println(a.solve(s));	
	}

	public int solve(String s){

		if(s == null || s.length() == 0) return 0;
		
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0'? 0:1; //문자열이 06으로 시작하면 0은 문자로 대체 불가하기 때문
		
		//2(1,2)
		for(int i=2;i<=n; i++) {
			int first = Integer.valueOf(s.substring(i-1,i));

			
			//12 (0,2)
			int second = Integer.valueOf(s.substring(i-2,i));
			if(first >=1 && first <=9) {
				dp[i] = dp[i] + dp[i-1];
			}
			if(second >= 10 && second <=26) {
				dp[i] = dp[i] + dp[i-2];
			}
		}
		return dp[n];
	}		
}
