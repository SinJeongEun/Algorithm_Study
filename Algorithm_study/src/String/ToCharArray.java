package String;

public class ToCharArray {

	public static void main(String[] args) {
		String s = ")a)d)v(v(";
		
		System.out.println("result : " + new ToCharArray().solve(s));

	}
	
	
	public String solve(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		int openbrace = 0;
		
		for(char c : s.toCharArray()) {
			if(c == '(') {
				openbrace++;
				
			}
			else if(c ==')') {
				if(openbrace==0) continue;
				openbrace--;
			}
			sb.append(c);
		}

		for(int i=sb.length()-1; i>=0;i--) {
			if(sb.charAt(i)=='(' && openbrace-- >0) continue;			
		
			result.append(sb.charAt(i));			
		}		
		return result.reverse().toString();
	}
}
