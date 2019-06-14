package bestalbum;

import java.util.*;

public class BestAlbum {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}); // [4, 1, 3, 0]
		solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop", "jazz"}, new int[] {500, 600, 800, 800, 2500, 100}); // [4, 1, 2, 3, 5]
	}

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList<>();
        
        HashMap<String, ArrayList<HashMap<Integer, Integer>>> hm = new HashMap<>();
        
        String strGenre = "";
        for(int i=0; i<genres.length; i++) {
        	strGenre = genres[i];
        	HashMap<Integer, Integer> innerHm = new HashMap<>();
        	innerHm.put(i, plays[i]);
        	if(hm.containsKey(strGenre)) {
        		hm.get(strGenre).add(innerHm);
        	} else {
        		ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        		list.add(innerHm);
        		hm.put(strGenre, list);
        	}
        }
        
        HashMap<String, Integer> totalPlaysMap = new HashMap<>();
        // 장르별 총 플레이 횟수 구하기
        for(String s: hm.keySet()) {
        	int totalPlaysInt = 0;
        	for(HashMap<Integer, Integer> i: hm.get(s)) {
        		for(int j: i.values()) {
        			totalPlaysInt += j;
        		}
        	}
        	// 새로운 해시맵에 총 횟수 저장하기

        	totalPlaysMap.put(s, totalPlaysInt);
        }
        
        // value 큰순서대로 key 뽑아서 list에 넣기
        ArrayList<String> orderedGenres = new ArrayList<>();
        
        Iterator<?> it = sortByValue(totalPlaysMap).iterator();
        while(it.hasNext()) {
        	orderedGenres.add((String) it.next());
        }
        
        // list안에서 value 내림차순, value 같으면 key 오름차순으로 정렬후 2개만 뽑아서 answer array에 넣기
        for(String s: orderedGenres) {
//        	System.out.println(s);
//        	System.out.println(hm.get(s));
        	sortDescByValueAscByKey(hm.get(s));
//        	System.out.println(hm.get(s));
        	
//    		System.out.println(hm.get(s).get(0).entrySet().iterator().next().getKey());
    		answerList.add(hm.get(s).get(0).entrySet().iterator().next().getKey());
    		if(hm.get(s).size() > 1) {
//    			System.out.println(hm.get(s).get(1).entrySet().iterator().next().getKey());
    			answerList.add(hm.get(s).get(1).entrySet().iterator().next().getKey());
    		}
        }
        
        
        answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = answerList.get(i).intValue();
        }
        
//        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
    
    public static List<String> sortByValue(Map<String, Integer> map) {
    	List<String> list = new ArrayList<>();
    	list.addAll(map.keySet());
    	
    	Collections.sort(list, new Comparator<Object>() {
    		@SuppressWarnings("unchecked")
			public int compare(Object o1, Object o2) {
    			Object v1 = map.get(o1);
    			Object v2 = map.get(o2);
    			
    			return ((Comparable<Object>) v1).compareTo(v2);
    		}
		});
    	
    	Collections.reverse(list);
    	return list;
    }
    
    public static ArrayList<HashMap<Integer, Integer>> sortDescByValueAscByKey(ArrayList<HashMap<Integer, Integer>> list){
    	
    	Collections.sort(list, new Comparator<HashMap<Integer, Integer>>() {
    		
    		public int compare(HashMap<Integer, Integer> o1, HashMap<Integer, Integer> o2) {
				
    			Collection<Integer> v1 = o1.values();
				Collection<Integer> v2 = o2.values();
				
				if(!v1.isEmpty() && !v2.isEmpty()){
		            return v2.iterator().next().compareTo(v1.iterator().next());
		        }else{
		            return 0;
		        }
				
    		}
		});
    	
    	return list;
    }
    
} 