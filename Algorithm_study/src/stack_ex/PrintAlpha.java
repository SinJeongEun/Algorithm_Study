package stack_ex;

import java.util.Stack;

public class PrintAlpha {

	public static void main(String[] args) {
		//주어진 숫자 만큼 대괄호 속 문자 출력하기
		String s = "12[a]2[bc]2[d]";
		PrintAlpha a = new PrintAlpha();
		System.out.println(a.solve(s));
	}
	
	public String solve(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder tmp = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int k = 0;
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				k = k*10 +c-'0'; //1, 12
			}
			else if(c =='[') {//숫자가 끝났다는 뜻이므로 숫자를 stack에 푸쉬
				countStack.push(k);
				
				tmp = new StringBuilder();
				k=0;
			}
			else if(c ==']') {
				stringStack.push(tmp);
				StringBuilder str = stringStack.pop();	
				
				for(int i=countStack.pop();i>0; i--) {
					System.out.println("-------------" + str);
					System.out.println("-@@-" + tmp);
					str.append(tmp);
				}
				result.append(str);
			}
			else {
				tmp.append(c);
			}
		}
		return result.toString();
	}

}
