package lifeboat;

import java.util.Arrays;

public class Lifeboat {
	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.solution(new int[] {70, 50, 80, 50}, 100)); // 3
//		System.out.println(s.solution(new int[] {70, 80, 50}, 100)); // 3
		System.out.println(s.solution(new int[] {50, 50, 70, 80, 150}, 210)); // 2
	}
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        // 1. 맨 뒤 노드 150
        int last = getLastNode(people);
        // 2. 210 - 150 = 60
        int rest = limit - last;
        // 3. 
        
        
        return answer;
    }

	private int getLastNode(int[] people) {
		for(int i=people.length-1; i>=0; i--) {
			if(people[i] > 0) {
				return i;
			}
		}
		return -1;
	}
}
