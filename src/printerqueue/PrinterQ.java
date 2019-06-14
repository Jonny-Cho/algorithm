package printerqueue;

import java.util.*;

public class PrinterQ {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {2, 1, 3, 2}, 2)); // 1
		System.out.println(s.solution(new int[] {1, 1, 9, 1, 1, 1}, 0)); // 5
	}
}

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<HashMap<Integer, Integer>> q = new LinkedList<>();
		LinkedList<HashMap<Integer, Integer>> answerQ = new LinkedList<>();
		LinkedHashMap<Integer, Integer> hm;
		
		for(int i=0; i<priorities.length; i++) {
			hm = new LinkedHashMap<>();
			hm.put(i, priorities[i]);
			q.add(hm);
		}
		
		while(!q.isEmpty()) {
			int count = 0;
			for(int i=1; i<q.size(); i++) {
				if((int)q.get(0).values().toArray()[0] < (int)q.get(i).values().toArray()[0]) {
					count++;
					break;
				}
			}
			if(count == 0) {
				answerQ.offer(q.poll());
			} else {
				q.offer(q.poll());
			}
		}
		
		for(int i=0; i<answerQ.size(); i++) {
			if(answerQ.get(i).get(location) != null) {
				answer = i+1;
				break;
			}
		}
		
		return answer;
	}
}