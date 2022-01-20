package Sort;

import java.util.Arrays;

public class HIndex {
	static int notUsed = 0;
	static int length = 0;
	public static void main(String[] args) {
		int citations[] = {3, 0, 6, 1, 5};
		new HIndex().solution(citations);

	}
	
	public int solution(int[] citations) {
        int answer = 0;
        length = citations.length;
        Arrays.sort(citations);
        
        for(int i=0;i<length;i++) {
        	if(citations[i] == 0) {
        		notUsed++;
        	}  
        	else break;
        }
        
        if(notUsed == length) return 0;
        
        for(int i=notUsed;i<length;i++) { 
        	int cite = length - i;
        	if(citations[i] >= cite) {        	
        		answer = cite;
        		break;
        	}
        }
    	System.out.print(answer);
        return answer;
    }

}
