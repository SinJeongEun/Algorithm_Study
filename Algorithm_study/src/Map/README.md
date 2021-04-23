- # Map

  - Map<Integer,String>map = new HashMap<>();
    - key값Integer  value값 String
  - 시간복잡도 O(1)
    - 키값만 알면 값을 알 수 있음
  - Map 이용
    - 1. Map + String(getOrDefault())
    - 2. Map + Array
    - 3. Map + Math.max(for문 사용하여 최댓값 찾기)
    - 4. Map + Set
         * Set은 중복값 허용 x
         * Set의 값을 Map의 키를 통해 가져옴
    - 5. Map + Map
         + <키1,값1> <키2,값2>  값1이 키2가 됨
    - 6. Set + Set

  - 개념설명

    - KeySet 방법

      - ```java
        for(String key : map.KeySet()){
        	Systemm.out.println("key:" + key + "value:" + map.get(key));
        }
        ```

    - EntrySet 방법

      - ```java
        for (Map.Entry<String,String> elem : map.entrySet()){
        	Systemm.out.println("key:" + elem.getKey() + "value:" + elem.getValue());
        }
        ```

    + Iterator 방법

      + ```java
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
        	String key = keys.next();
        	Systemm.out.println("key:" + key + "value:" + 				map.get(key));
        }
        ```
  - 함수
    - **getOrDefault**()
    + ```java
     map.put(ch, map.getOrDefault(ch, 0)+1);
      ```
      - ch가 존재하면 ch의 기존값을 가져온다.
      - ch가 존재하지 않으면 0을 가져온다.

        

