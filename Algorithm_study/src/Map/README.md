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
    - [**getOrDefault**](https://github.com/SinJeongEun/Algorithm_study/blob/master/Algorithm_study/src/Map/MapGetOrDefault.java)
     + ```java
       map.put(ch, map.getOrDefault(ch, 0)+1);
       ```
        - ch가 존재하면 ch의 기존값을 가져온다.
        - ch가 존재하지 않으면 0을 가져온다.
  - Map 키,값 정렬하기
    + ```java
      Map<String, Integer> map = new HashMap<>();
        map.put("신", 3);
        map.put("이", 4);
        map.put("김", 1);
        map.put("박", 5);

        // key 기준으로 정렬하기
        Map<String, Integer> sortedMap1 = new TreeMap<>(map);
        for(String key : sortedMap1.keySet()) {
            System.out.println("key : " + key + " >>> " +map.get(key));
        }

        System.out.println();
        System.out.println();

        // value 기준으로 정렬하기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : entryList) {
            System.out.println("key : " + entry.getKey() + " >>> " +entry.getValue());
        }

    }
    
   // key : 김 >>> 1
   // key : 박 >>> 5
   // key : 신 >>> 3
   // key : 이 >>> 4


  //  key : 김 >>> 1
  //  key : 신 >>> 3
  //  key : 이 >>> 4
  //  key : 박 >>> 5
      ```

        

