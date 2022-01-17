package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubArraySort {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		new SubArraySort().solution(array, commands);

	}
	
	public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer =  new ArrayList<>();

        for(int i=0;i<commands.length;i++) {
        	//Arrays.copyOfRange로 배열 부분 복사 가능
        	//int[]tmp = Arrays.copyOfRange(array, i, j);
        	List<Integer> tmp = new ArrayList<>();
        	for(int j=commands[i][0]; j<=commands[i][1]; j++) {
        		tmp.add(array[j-1]);
        	}
			Collections.sort(tmp);		
			answer.add(tmp.get(commands[i][2]-1));
        }
        System.out.println(answer);
        	
        return answer;
    }
	
	
	

}
