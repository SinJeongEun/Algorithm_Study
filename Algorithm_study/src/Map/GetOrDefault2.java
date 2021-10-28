package Map;

import java.util.HashMap;
import java.util.Map;
public class GetOrDefault2 {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> p = new HashMap<>();
        String find="";
        for(String mem : participant){
            p.put(mem, p.getOrDefault(mem, 0)+1);
        }

        for(String complete : completion){
            p.put(complete, p.get(complete)-1);
        }

        for(String mem : p.keySet()){
            if(p.get(mem) > 0){ find = mem;}
        }

        return p.entrySet().stream()
        .filter(e -> e.getValue() > 0)
        .findFirst()
        .get()
        .getKey();
        // return find;

    }
}