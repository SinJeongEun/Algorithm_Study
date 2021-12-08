package stack_ex;

import java.util.Stack;

public class PrintAlpha {

	public static void main(String[] args) {
		//�־��� ���� ��ŭ ���ȣ �� ���� ����ϱ�
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
			else if(c =='[') {//���ڰ� �����ٴ� ���̹Ƿ� ���ڸ� stack�� Ǫ��
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
