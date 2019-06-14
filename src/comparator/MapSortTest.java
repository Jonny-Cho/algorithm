package comparator;

import java.util.*;

public class MapSortTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
        map.put("A", 4);
        map.put("B", 4);
        map.put("C", 4);
        map.put("D", 2);
        map.put("E", 6);
        map.put("F", 1);
        map.put("G", 2);
        
        System.out.println(sortDescByValue(map));
        
	}
	
	public static LinkedHashMap<String, Integer> sortDescByValue(Map<String, Integer> map){
		// value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
//        System.out.println(list);
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        
        // 순서유지를 위해 LinkedHashMap을 사용
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
//        System.out.println(sortedMap);
        
		return sortedMap;
	}

}
