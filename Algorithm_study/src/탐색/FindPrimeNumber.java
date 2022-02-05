package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.탐색;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumber {
    static  HashSet<Integer> hashSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        char[] charArr = numbers.toCharArray();

        int k = 1; // 만들 수 있는 자릿수느 1 ~ char.length
        StringBuilder sb = new StringBuilder(); // 만들어진 조합 숫자로 수 만들기
        boolean visited[] = new boolean[charArr.length]; //방문 확인
        Arrays.fill(visited,false);

        //수 만들기
        backTrack(k, sb, charArr, visited);

        //소수 찾기
        answer = hashSet.size();
        for(int number: hashSet){
            for(int j=2;j<=Math.sqrt(number);j++){
                if(number % j == 0) {
                    --answer; // 소수가 아니면 갯수 차감
                    break;
                }
            }
        }
        return answer;
    }

    public HashSet<Integer> backTrack ( int k, StringBuilder sb,char[] charArr, boolean[] visited) {
            if (k <= charArr.length){
                if (sb.length() == k) {
                    //맨 앞에 0이 오는 경우 0제거
                    while(sb.length() > 0 && sb.charAt(0) == '0'){
                        sb.deleteCharAt(0);
                    }
                    if(sb.length() >0 && !sb.toString().equals("1")){ //0이나 1 이 아닌 경우만 hashset에 삽입
                        //중복 삽입 제한을 위해 HashSet<> 사용
                        hashSet.add(Integer.parseInt(sb.toString()));
                    }
                }else{
                    for (int i = 0; i < charArr.length; i++) {
                        if(visited[i]) continue;
                        visited[i] = true;
                        sb.append(charArr[i]);
                        backTrack(k, sb, charArr, visited);
                        //조합에서 모든 후처리 (방문 여부 변경, sb 길이 조정)는 재귀호출 뒤에 작성한다 **
                        visited[i] = false;
                        if(sb.length()>0){
                            sb.deleteCharAt(sb.length()-1);
                        }
                    }
                    backTrack(k + 1,sb, charArr,visited);  //k값 증가시키며 조합 가능 개수 늘리기
                }
            }
       return hashSet;
    }
}
