package Map;

import java.util.HashMap;
import java.util.Map;

public class Marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		new Marathon().solution(participant, completion);
	}
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> checkMap = new HashMap<>();
        
        for(String p : participant) {
        	checkMap.put(p, checkMap.getOrDefault(p, 0)+1);
        }
       
        for(String c : completion) {
        	checkMap.put(c,checkMap.get(c)-1);
        }
        
        for(String key : checkMap.keySet()) {
        	if(checkMap.get(key) == 1) {
        		answer = key;
        		break;
        	}
        }
        System.out.println("answer : " + answer);
        return answer;
    }

}
