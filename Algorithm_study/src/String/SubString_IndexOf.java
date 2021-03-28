package String;

public class SubString_IndexOf {

	public static void main(String[] args) {
		String str[] = {"test", "teach"};
		System.out.println(new SubString_IndexOf().solve(str));
		
		

	}
	
	public String solve(String str[]) {
		
		if(str.length ==0) return "";
		
		String firststr = str[0];
		
		for(int i=1;i<str.length;i++) {
			while(str[i].indexOf(firststr) !=0 ) {
				firststr = firststr.substring(0, firststr.length()-1);
			}
		}
		
		return firststr;
	}

}
