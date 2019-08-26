package stick;

import java.util.LinkedList;

public class Stick {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()(((()())(())()))(())")); // 17
	}
	
}

class Solution{
	public int solution(String arrangement) {
		int answer = 0;
		
		String[] arr = arrangement.split("");
		
		LinkedList<Integer> stackOpen = new LinkedList<>();
		
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i].equals("(") && arr[i+1].equals("(")) {
				stackOpen.push(i);
			}
			
			if(arr[i].equals(")") && arr[i+1].equals(")")) {
				startIndex = stackOpen.pop();
				endIndex = i+1;
				answer += countRazer(arr, startIndex, endIndex);
			}
		}
		
		return answer;
	}

	private int countRazer(String[] arr, int startIndex, int endIndex) {
		int count = 0;

		for(int i=startIndex; i<endIndex; i++) {
			if(arr[i].equals("(") && arr[i+1].equals(")")) {
				count++;
			}
		}
		
		return count+1;
	}

}
