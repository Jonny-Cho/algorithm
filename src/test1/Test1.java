package test1;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {5, 3, 7}, new int[] {3, 7, 6})); // 3
		System.out.println(s.solution(new int[] {1, 2}, new int[] {2, 3, 1})); // 2
		System.out.println(s.solution(new int[] {3, 8, 6}, new int[] {5, 6, 4})); // 2
	}

}

class Solution{
	
	public int solution(int[] goods, int[] boxes) {
		Arrays.sort(goods);
		Arrays.sort(boxes);
		int answer = 0;
		int i = goods.length-1;
		int j = boxes.length-1;
		while (i >= 0 && j >= 0){
			if(goods[i] <= boxes[j]) {
				answer++;
				j--;
			}
			i--;
		}
		return answer;
	}
	
}
