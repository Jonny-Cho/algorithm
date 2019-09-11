package budget;

import java.util.Arrays;

public class Budget {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {120, 110, 140, 150}, 485)); // 127
	}
}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets);
        
        return answer;
    }
}