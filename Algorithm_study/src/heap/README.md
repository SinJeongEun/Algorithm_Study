#### 최소 힙은 루트노드의 최솟값을 보장하고, 마지막 노드의 최댓값은 보장하지 않는다!!
#### 최대 힙은 루트노드의 최댓값을 보장하고, 마지막 노드의 최솟값은 보장하지 않는다!!

- 최소 힙
  - ```java
     PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>();
    ```
    
- 최대 힙
  - ```java
     PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
    ```
- [**Queue -> List 정렬**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/heap/DualPriorityQueue.java)
  - ```
  - List<>tmp = que.stream().collect(Collectors.toList());  //List 로 변환
      Collections.sort(tmp);
    ```
