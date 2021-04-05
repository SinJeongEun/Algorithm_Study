- # [**2D_Array <=> List<List<Integer>>**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/Array_2D/Convert_2DArray_List.java)
  -   ## 2D_Array -> List<List<Integer>>
      -  각 내부 리스트 먼저 생성후 2차원 리스트에 add
  -  ## List<List<Integer>> ->  2D_Array
     - 2차원 배열의 구조 먼저 정의해애됨**! 행먼저 크기 정하고, 각 행마다 column 수 다를 수 있으니 for 문으로 list.get(i).size 사용하여 column 크기 정한다.

- # [**해당 행,열 0으로 만들기**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/Array_2D/MatrixZero.java)
   -HashSet 사용하여 0이되어야 하는 행 , 열의 주소를 각각 저장함
    - HashSet은 Set의 성질을 그대로 상속받습니다. 
    - Set은 객체를 **중복해서 저장할 수 없고** 하나의 null 값만 저장할 수 있습니다.
      -  Set 인터페이스를 구현한 클래스로는 HashSet과 TreeSet이 있는데 HashSet의 경우 정렬을 해주지 않고 TreeSet의 경우 자동정렬을 해준다는 차이점이 있습니다. Set의 가장 큰 장점은 중복을 자동으로 제거해준다는 점입니다.
    - 저장 순서가 유지되지 않습니다.  만약 요소의 저장 순서를 유지해야 한다면 JDK 1.4부터 제공하는 LinkedHashSet 클래스를 사용해야 함.
    -  값 추가 : .add()   값 삭제:  .remove()
    -  값 출력 -> Iterator 사용
      - ```
      Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) {//값이 있으면 true 없으면 false
    System.out.println(iter.next());
} ```
     - Set에는 인덱스로 객체를 가져오는 get(index) 메소드가 없고, 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자(Iterator)를 제공함
       

 
