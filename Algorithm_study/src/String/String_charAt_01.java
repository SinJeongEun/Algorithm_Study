package String;

public class String_charAt_01 {

	public static void main(String[] args) {
		
		String num1 ="123";
		String num2 = "888";
		
		System.out.println
		(new String_charAt_01().solve(num1, num2));
	}
		
	public String solve(String num1,String num2) {
		StringBuilder sb = new StringBuilder();
		int s1 = num1.length()-1;
		int s2 = num2.length()-1;
		int carry = 0;
				
		while(s1 >= 0 || s2 >= 0) {
			int n1 = 0;
			int n2 = 0;
			
			if(num1.length()>=0) {
				n1= num1.charAt(s1)-'0';
				}
			if(num2.length()>=0) {
				n2= num2.charAt(s2)-'0';			
			}
			
			int sum = (n1+n2) + carry;
			carry = sum/10;
			sb.append(sum%10);
			
			s1--;
			s2--;
			
		}
		if(carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}	
	
}
