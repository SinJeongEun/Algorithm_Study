- ## permutaion
  + 순서고려o (nPr)
  +  ``` java
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> tmp = new ArrayList<>();

      backtrack(); //함수 호출

      //nums{1,2,3} 배열에서 조합 가능한 경우의 수
      public void backtrack(){
          if(tmp.size() == nums.length){
              result.add(new ArrayList<>(tmp))
          }else{
              for(int i=0;i<nums.lenght;i++){
                  //중복 항목 불가능
                  if(tmp.contains(num[i])) continue;
                  tmp.add(nums[i]);
                  backtrack(); //재귀적 호출
                  tmp.remove(tmp.size()-1); // ex) n=3,depth=3일 때 1-1-1 1-1-2  1-1-3 그리고 다시 1-2~ 를 방문하기 위해 tmp의 사이즈를 줄여서 상위 for문을 돌도록 하기 위함
              }
          }
      }
      ```
      
  + 추가
    - 방문체크를 위한 visited 나 조합을 저장하는 tmp(or sb)는 꼭 재귀적 호출 뒤에만 작성해야됨, ( if(tmp.size() == nums.length)  안에 작성해도 안됨!!!)
      - [**위의 코드가 포함 된 코드 링크**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/%ED%83%90%EC%83%89/FindPrimeNumber.java)
    





- ## combination
  + 조합 ( nCr)
  +  ``` java
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> tmp = new ArrayList<>();

      backtrack(); //함수 호출 매개변수에 start=1

      //nums=3 k=2인 경우 조합 가능한 경우의 수 (3C2)
      public void backtrack(){
          if(tmp.size() == k){
              result.add(new ArrayList<>(tmp))
          }else{
              for(int i=start;i<=nums;i++){
                  tmp.add(nums[i]);
                  backtrack(~,i+1); //다음 start 수를 +1로 지정 
                  tmp.remove(tmp.size()-1);
              }
          }
      }
    
