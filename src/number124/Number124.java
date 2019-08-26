package number124;

public class Number124 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
//		for(int i=1; i<=20; i++) {
//			System.out.println("i = " + i + ", 124나라 = " + s.solution(i));
//		}
		
		for(int i=1; i<=20; i++) {
			System.out.println("i = " + i + ", 124나라 = " + s.newSolution(i));
		}
		
	}

}

class Solution{
	public String solution(int n) {
		int quotient = n / 3;
		int remainder = n % 3;
		
		if(quotient == 0) return String.valueOf(remainder);

		StringBuilder sb = new StringBuilder(String.valueOf(remainder));
		
		while(quotient > 0) {
			remainder = quotient % 3;
			sb.insert(0, String.valueOf(remainder));
			quotient /= 3;
		}

		// sb - 0 메꿔주기
		// sb 뒤에서부터 탐색해서 0이 있으면
		// 앞자리에서 1을빼고 0을 3으로 만듬
		// 앞자리가 -1이된다면 또 그 앞자리에서 1을 빼고 2로 만듬
		
		char[] charArr = new char[sb.length()];
		sb.getChars(0, sb.length(), charArr, 0);
		
		for(int i=charArr.length-1; i>=1; i--) {
			if(charArr[i] == '0' || charArr[i] == '/') {
				charArr[i-1] = (char)(charArr[i-1]-1);
				charArr[i] += 3;
			}
			// 3이 들어있으면 4로 바꿈
			if(charArr[i] == '3') charArr[i] = '4';
		}
		
		// 맨앞의 0은 출력 x
		if(charArr[0] == '0') {
			char[] newCharArr = new char[charArr.length-1];
			System.arraycopy(charArr, 1, newCharArr, 0, newCharArr.length);
			return String.valueOf(newCharArr);
		}
		
		return String.valueOf(charArr);
	}
	
	public String newSolution(int n) {
		String answer = "";
		
//		int quotient = n / 3;
		int remainder = n % 3;
		
		StringBuilder sb = new StringBuilder();
		
		while(n > 0) {
			remainder = n % 3;
			if(remainder == 0) {
				remainder = 4;
				n = (n / 3) - 1;
			} else {
				n /= 3;
			}
			sb.insert(0, String.valueOf(remainder));
		}
		
		answer = sb.toString();
		return answer;
	}
	
}