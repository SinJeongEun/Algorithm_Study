package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ElectricWire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] =  Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 왼쪽 전봇대 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];
        int max = 0;

        // 최장 증가 부분수열 찾기
        // i가 커질수록 반대편 전봇대의 index값이 커져야 전선이 겹치지 않는다.
        // 시간 복잡도 n*n
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // 방법2 : 이분탐색
        // 시간복잡도 nlogn
        /*for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(dp, 0, max, arr[i][1]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            dp[pos] = arr[i][1];
            if (pos == max) {
                max++;
            }
        }*/

        // 삭제해야 되는 전선 최소 수
        System.out.println(n - max);
    }
}
