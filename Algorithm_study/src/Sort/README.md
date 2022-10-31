# Sort

- ## [**CompareTo()**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/Sort/CompareTo.java)

  + ```java
        public int compareTo(){
    	 return A.compareTo(b);
        }
        // 1. A = B -> 0
        // 2. A > B -> 1     내림차순
        // 3. A < B -> -1    오름차순
        ```

    

- ## [**Comparator**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/Sort/ComparatorTest.java)

- ## Priority Queue  시간 복잡도 (O(logn))
  - 최소 힙 : 루트노드가 최솟값
       ```java
       PriorityQueue<Integer> pq
              = new PriorityQueue<Integer>();
      ```
  - 최대 힙 : 루트노드가 최댓값
   ```java   
     PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
    ```
- ## Binary Search 시간 복잡도 (O(logn))

- ### Array
  - Arrays.sort();   
    - Arrays.sort() 의 경우 dual-pivot Quicksort 알고리즘을 사용한다.
    - 평균 시간복잡도가 O(nlogn) 이고 매우 빠른 알고리즘인 것은 맞다. 
    - 그러나 최악의 경우 시간복잡도는 O(n2) 이다.
  - Arrays.sort(arr,Collections.reverseOrder());
  
- ### List  
  - Collections.sort(); : Arrays.sort() 보다 빠르다.
    -  Collections.sort() 은 Timsort이다. 
    - Timsort 의 경우 합병 및 삽입정렬 알고리즘을 사용한다. 
    - 이렇게 두 가지가 섞여있는 정렬 알고리즘을 hybrid sorting algorithm 이라고 한다.
    - 합병정렬(Merge Sort)의 경우 최선, 최악 모두 O(nlogn)  을 보장한다. 
    - 삽입정렬(Insertion sort)의 경우 최선의 경우는 O(n) , 최악의 경우는 O(n2) 이다. 
    - 두 정렬 모두 안정 정렬(stable sort)이기 때문에 Timsort를 hybrid stable sorting algorithm이라고도 한다.
    - 시간복잡도 O(n) ~ O(nlogn) 을 보장한다
  - Collections.reverseOrder()

- ### Array -> List
  - Arrays.asList()
  - new ArrayList<>(Arrays.asList())
  - Collectors.toList()


- ### List -> Array 
 - toArray() - java.util.List
