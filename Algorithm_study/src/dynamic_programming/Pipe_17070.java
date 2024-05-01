package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pipe_17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N][N][3];
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][1][0] = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if((r == 0 && c < 2) || arr[r][c] == 1) continue;

                // 대각선
                if(r - 1 >= 0 && arr[r - 1][c] == 0 && arr[r][c - 1] != 1 && arr[r - 1][c - 1] != 1) {
                    dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                }

                // 세로
                if(r - 1 >= 0 && arr[r - 1][c] != 1) dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

                // 가로
                if(arr[r][c - 1] != 1) dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
