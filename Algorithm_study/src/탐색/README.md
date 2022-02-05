- [**소수 감별 법**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/%ED%83%90%EC%83%89/FindPrimeNumber.java)
  - 0,1은 소수가 아니므로 j=2부터 시작, 주어진 범위의 마지막 숫자(number)의 제곱근 Math.sqrt(number) 까지만  반복하며 검사한다.
  - ```
    for(int j=2;j<=Math.sqrt(number);j++){
                if(number % j == 0) {
                    --answer; // 소수가 아니면 갯수 차감
                    break;
                }
            }
    ```
