package avg;

public class Avg {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {1, 2, 3, 4})); // 2.5
		System.out.println(s.solution(new int[] {5, 5})); // 5
	}

}

class Solution{
	public double solution(int[] arr) {
		double answer = 0;
		
		double sum = 0;
		for(int i : arr) {
			sum += Double.valueOf(i);
		}
		
		answer = sum/arr.length;
		
		return answer;
	}
}