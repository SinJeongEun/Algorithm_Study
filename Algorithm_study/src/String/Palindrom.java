package String;

public class Palindrom {

	public static void main(String[] args) {
		String str = "banana";
		System.out.println(new Palindrom().solve(str));
		
	}
	
	private int start,end;
	
	public String solve(String s) {
		if(s.length() <2) return s;
		
		for(int i=0;i<s.length()-1;i++) {
			findSubstring(s,i,i);
			findSubstring(s,i,i+1);
		}
		return s.substring(start, start + end);
	}

	public void findSubstring(String s, int left, int right) {
		while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right ++;
		}
		if(end < right-left-1) {      // end��  ���� �� palindrom �� ���̸� �ǹ�   ***************  �Ʒ� ���ǹ��� �� ���� �ʿ�************************
			end = right-left-1; //6     
			start = left + 1; //0
		}
		
	}

}
