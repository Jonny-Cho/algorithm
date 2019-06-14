package hindex;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {3, 0, 6, 1, 5})); // 3
		System.out.println(s.solution(new int[] {66, 88, 100, 4, 1, 2})); // 4
		System.out.println(s.solution(new int[] {0, 0, 0})); // 0
		System.out.println(s.solution(new int[] {1, 1, 1, 2})); // 1
		System.out.println(s.solution(new int[] {22, 42})); // 2
		System.out.println(s.solution(new int[] {100, 80, 70})); // 3
	}

}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
        	if(citations[i] >= citations.length - i) {
        		answer = citations.length - i;
        		break;
        	}
        }
        
        return answer;
    }
}