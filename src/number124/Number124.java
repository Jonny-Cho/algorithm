package number124;

public class Number124 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		for(int i=1; i<=20; i++) {
			System.out.println("i = " + i + ", 124³ª¶ó = " + s.solution(i));
		}
	}

}

class Solution{
	public String solution(int n) {
		String answer = "";
		
		int quotient = n / 3;
		int remainder = n % 3;
		
		answer = String.valueOf(remainder);
		
		while(quotient > 0) {
			
			remainder = quotient % 3;
			quotient /= 3;
		}
		
		
//		if(quotient == 0) {
//			sb.append(String.valueOf(remainder));
//		} else {
//			sb.append(String.valueOf(quotient) + String.valueOf(remainder));
//		}
		
//		for(int i=0; i<sb.length(); i++) {
//			if(sb.charAt(i) == '3') {
//				sb.setCharAt(i, '4');
//			}
//		}
		
		
		return answer;
	}
}