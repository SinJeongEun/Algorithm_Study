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
                  tmp.remove(tmp.size()-1); // **********이 부분 정확한 이유 공부 후 설명 보충하기
              }
          }
      }
    





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
                  tmp.remove(tmp.size()-1); // **********이 부분 정확한 이유 공부 후 설명 보충하기
              }
          }
      }
    
