package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        List<int[]> result = new ArrayList<>();
        int total = brown + yellow;
        int row = 0; //세로
        int col = 0; //가로

        for(int i=3;i<total/2;i++){ // 가로 세로 길이가 3 이상이여야 가운데에 노란색이 들어갈 수 있음
            col = i;
            System.out.println("---------- " + col);
            if(total % col == 0 ) {
                row = total/col;

                if(row * col == total && row >= col && (row-2) * (col-2) == yellow){ // (row-2) * (col-2) == yellow 이여야 딱 가운데와 노란색 갯수가 같아야 됨
                    System.out.println("~~  " + row + "  " + col);
                    int tmp[] = {row, col};
                    result.add(tmp);

                }
            }
        }
        if(result.size()>1) {
            Collections.sort(result,(a,b) -> a[0] - b[0]);
        }
        System.out.println(Arrays.stream(result.get(0)).toString());
        return result.get(0);
    }
}
