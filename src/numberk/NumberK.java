package numberk;

import java.util.Arrays;

public class NumberK {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))); // 5, 6, 3
	}

}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tempArr;
        for(int i=0; i<commands.length; i++) {
    		int start = commands[i][0]-1;
    		int end = commands[i][1]-1;
    		int target = commands[i][2]-1;
        	
        	tempArr = new int[end - start + 1];
        	for(int j=0; j<tempArr.length; j++) {
        		tempArr[j] = array[j + start];
        	}
        	
        	Arrays.sort(tempArr);
        	answer[i] = tempArr[target];
        }
        
        return answer;
    }
}