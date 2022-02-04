package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class MockTest {
    public List<Integer> solution(int[] answers) {
        List<Integer> result = new ArrayList<>();
        int[][]person = {{1,2},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[]score = new int[person.length];
        Arrays.fill(score,0);

        for(int i=0;i<person.length;i++){ //명수 만큼 반복
            for(int a=0;a<answers.length;a++){
                for(int j=a;j<a+1;j++){
                    int myIndex = j;
                    if(a >= person[i].length){
                        myIndex = a % person[i].length;
                    }
                    if(answers[a] == person[i][myIndex]) {
                        score[i]++;
                    }
                    else break;

                }
            }


        }
        int max = Arrays.stream(score).max().getAsInt();
        for(int p=0;p< score.length;p++){
            if(score[p] == max){
                result.add(p+1);
            }
        }
        Collections.sort(result);

        return result;
    }
}
