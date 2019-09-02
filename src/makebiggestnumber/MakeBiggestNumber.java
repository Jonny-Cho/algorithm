package makebiggestnumber;

public class MakeBiggestNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("1924", 2)); // "94"
		System.out.println(s.solution("1231234", 3)); // "3234"
		System.out.println(s.solution("4177252841", 4)); // "775841"
		System.out.println(s.solution("10000", 2)); // "100"
		System.out.println(s.solution("0000100", 3)); // "100"
	}
}

class Solution {
    public String solution(String number, int k) {
    	int index = 0;
		StringBuilder answer = new StringBuilder();
		int maxIndex = -1;
		int cntDeletedNumber = 0;
		while(index < number.length() - k) {
			int maxNum = 0;
			for(int i=index; i<=index+k; i++) {
				maxNum = Math.max(maxNum, number.charAt(i)-'0');
			}
			for(int i=index; i<=index+k; i++) {
				if(number.charAt(i)-'0'==maxNum) {
					cntDeletedNumber = i - maxIndex - 1;
					maxIndex = i;
					break;
				}
			}
			answer.append(maxNum);
			k -= cntDeletedNumber;
			index = maxIndex+1;
		}
		return answer.toString();
    }
}