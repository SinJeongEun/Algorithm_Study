package Map;

import java.util.HashMap;
import java.util.Map;

public class MapGetOrDefault {

	public static void main(String[] args) {
		String s = "inflearninlove";
		System.out.println(solve(s));
				
	}
	
	public static int solve(String s) {
		//1.error check
		if(s==null || s.length()==0) return -1;
		
		//2. ���� �׸� data structure
		Map<Character,Integer>map = new HashMap<>();
		
		//3. for, while
		for(char ch : s.toCharArray()) {
			
			map.put(ch, map.getOrDefault(ch, 0)+1);
			// ch�� �����ϸ� ch�� �������� �����´�.
			// ch�� �������� ������ 0�� �����´�.
//			if(!map.containsKey(ch)) {
//				map.put(ch,1);
//			}
//			else{
//				map.put(ch, map.get(ch)+1);
//			}
		}
		
		//4. ���� 1�� index�� �����ϸ� ��
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
		
	}

}
