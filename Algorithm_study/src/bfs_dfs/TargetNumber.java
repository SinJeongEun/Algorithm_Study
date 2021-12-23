package bfs_dfs;

public class TargetNumber {

	public static void main(String[] args) {
		int[]numbers = {1,1,1,1,1};
		int target = 3;
		new TargetNumber().solution(numbers,target);

	}
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        //������ numbers[0]���� �ϴ°� �ƴϰ� 0���� �����ϱ� ������ 0 + numbers[0] / 0 - numbers[0] �� ��� ��� ���� ��.
        System.out.print(answer);
        return answer;
    }
    
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
	
}
