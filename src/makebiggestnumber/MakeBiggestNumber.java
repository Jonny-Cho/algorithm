package makebiggestnumber;

public class MakeBiggestNumber {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("1924", 2)); // "94"
		System.out.println(s.solution("1231234", 3)); // "3234"
		System.out.println(s.solution("4177252841", 4)); // "775841"
	}

}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        return makeBiggestNumber(number, k, answer);
    }

	private String makeBiggestNumber(String number, int k, String answer) {
		if(k == 0) return answer += number;
		
		int maxNum = 0;
		int maxNumIndex = maxNumIndex(number, k, maxNum);
		
		answer += number.charAt(maxNumIndex);
		number = number.substring(maxNumIndex+1);
		return makeBiggestNumber(number, k-maxNumIndex, answer);
	}

	private int maxNumIndex(String number, int k, int maxNum) {
		int maxNumIndex = 0;
		for(int i=0; i<=k; i++) {
			maxNum = Math.max(maxNum, number.charAt(i) - '0');
		}
		maxNumIndex = number.indexOf(maxNum + "");
				
		return maxNumIndex;
	}
}