package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {

	static int max_size = 0;
	public static void main(String[] args) {
		int[]numbers  = {6, 10, 2};
		new BiggestNumber().solution(numbers);
	}
	
	public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            String tmp = numbers[i] + "";
            list.add(tmp);
            max_size = Math.max(max_size, tmp.length());
        }
        
        Collections.sort(list, new Comparator<String>(){
           @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                int cmp1 = Integer.parseInt(o1+o2);
                int cmp2 = Integer.parseInt(o2+o1);
                
                if(cmp1> cmp2){
                    return -1;
                }else if(cmp2> cmp1){
                    return 1;
                }
                return 0;
            }
        });
        
        if(list.get(0).equals("0")){
            return "0";
        }else{
            for(int i=0; i<list.size(); i++){
                answer += list.get(i);
            }
            return answer;
        }
    }
    
}
