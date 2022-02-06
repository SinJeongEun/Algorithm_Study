package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.greedy;

import java.util.Arrays;
import java.util.Collections;

public class MakeLargeNumber {
    static  int n =0;
    static  String max = "";
    int maxIndex = 0;
    static int start = 0;
    static int end = 0;
    public String solution(String number, int k) {
        //조합 이용 nCr
        //숫자를 뽑을 때 배열의 순서를  유지해야됨 (뒤죽박죽 뽑기 x)
        //이 문제는 시간을 줄이는게 중요
        //두 수 비교하여 큰 수만 result에 삽입한다.
        //문자열의 처음부터 조합하지 않고 limit이 보장 되는 선에서 가장 큰 수 부터 시작한다.

        StringBuilder sb = new StringBuilder();

        int limit = number.length() - k;

        //문자열의 처음부터 조합하지 않고 limit이 보장 되는 선에서 가장 큰 수 부터 시작한다.
        backTracking(limit,sb,number.split(""));

        return sb.toString();

    }

    public void backTracking(int limit, StringBuilder sb, String[] numbers){
        if(sb.length() < limit) {
            end = numbers.length - limit + sb.length();
            if(end >= numbers.length) end = numbers.length-1;
            System.out.println(start + "           " + end);
            for(int i=start;i<=end;i++){
                if(numbers[i].compareTo(max) > 0) {
                    max = numbers[i];
                    maxIndex = i;
                }
            }
            sb.append(max);
//            System.out.println("~~~~~~   " + max);
            //max 값 초기화
            max = "";
            //다음 탐색 범위 지정
            start = maxIndex+1;
            if(start >= numbers.length) {
                System.out.println("~~~~~~   " );
                start = numbers.length-1;
            }

            backTracking(limit,sb,numbers);
        }

    }
}
