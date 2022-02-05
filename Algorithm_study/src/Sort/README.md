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
- ## Binary Search  시간 복잡도 (O(logn))

- ### Array
  - Arrays.sort();   
  - Arrays.sort(arr,Collections.reverseOrder());
  - 
- ###List
  - Collections.sort();
  - Collections.reverseOrder()

- ### Array -> List
  - Arrays.asList()
  - new ArrayList<>(Arrays.asList())
  - Collectors.toList()


- ### List -> Array 
 - toArray() - java.util.List
