package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingClothes {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"}
		,{"green_turban", "headgear"}};
		
		new MatchingClothes().solution(clothes);
						
	}
	
	 public int solution(String[][] clothes) {
	        int answer = 0;
	        int answer2 = 1;
	        List<Integer>counts = new ArrayList<>();
	        Map<String,Integer> my_clothes = new HashMap<>();
	        
	        for(String[] a : clothes) {
	        	my_clothes.put(a[1], my_clothes.getOrDefault(a[1], 0)+1);
	        }
	        
	        for(String key : my_clothes.keySet()) {
	        	counts.add(my_clothes.get(key)+1); // 입지 않는 경우를 위해 +1
	        }
	        
	        for(int c : counts) {
	        	answer2 *= c;
	        }
	        
	        answer += answer2 - 1; //모든 옷을 안 입는 경우 제거를 위해 -1
	        		
	        System.out.println(answer);
	        return answer;
	    }
	}

