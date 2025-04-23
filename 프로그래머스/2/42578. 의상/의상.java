import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            String str = c[1];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int answer = 1;
        for (int v : map.values()) {
            answer *= (v + 1);
        }

        return answer - 1; 
    }
}
