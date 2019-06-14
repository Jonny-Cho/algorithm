package divisor;

public class SumDivisor {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(12)); // 28
		System.out.println(s.solution(5)); // 6
	}

}

class Solution{
	
	public int solution(int n) {
		int answer = 0;
		
		for(int i=1; i<=n/2; i++) {
			if(n%i == 0) answer+=i;
		}
		answer+=n;
		
		return answer;
	}
	
}
