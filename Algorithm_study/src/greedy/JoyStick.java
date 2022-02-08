package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.greedy;

import java.util.ArrayList;
import java.util.List;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        //처음은 A로 초기화
        StringBuilder init = new StringBuilder();
        char[]nameArr = name.toCharArray();
        for(char s : nameArr) init.append("A");
        int length = name.length();

        //바꿔야될 인덱스 파악하여 배열에 담기
        List<Integer> change = new ArrayList<>();
        for(int i =0;i<length;i++){
            if(nameArr[i] - init.charAt(i) != 0) {

                change.add(i);
            }
        }
        for(int j : change)System.out.println(j+"     //");

        //각 경우의 수 중 최솟값을 배열에 삽입
        int min = 0;
        int cursor = 0;
        int start = change.get(0) - 0 <= length - change.get(change.size()-1) ? 0: change.size()-1;

        int now =0;
        int next = 0;
        int sum = 0;

        while(!change.isEmpty()){
            //시작점 알려주기
            now = start;

            //바꾸기
            cursor = Math.min(nameArr[change.get(now)] - 'A' , 1 + 'Z' - nameArr[change.get(now)]);

            int tmp = change.get(now);
            change.remove(now);

            if(change.size() == 0) {
                sum += cursor;
                break;
            }

            int front =  Math.abs(change.get(0) - tmp);
            int back =  Math.abs(change.get(change.size()-1) - tmp);

            if( front <= back) {
                //change의 맨 앞 원소로 이동
                if(front <= length/2) min =front;
                else{
                    if(tmp > change.get(0)) min = length - tmp + change.get(0) - 0;
                    else min = tmp-0 + length - change.get(0);
                }
            }else{
                //change의 맨 뒤 원소로 이동
                if(back <= length/2) min =back;
                else{
                    if(tmp > change.get(change.size()-1)) min = length - tmp + change.get(0) - 0;
                    else min = tmp-0 + length - change.get(change.size()-1);
                }
            }

            System.out.println(min +"  ~~~~~~~~~~~~~~~~~~~    "+cursor );

            sum += cursor + min;
            start = next;
            System.out.println("---  " + sum);
        }

        System.out.println(sum);

        answer = sum;
        return answer;
    }
}
