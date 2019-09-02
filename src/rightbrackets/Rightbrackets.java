package rightbrackets;

public class Rightbrackets {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("(()(()((()()()()()())))))))(()()()()()")); //true
	}

}

class Solution {
    boolean solution(String s) {
        int sum = 0;
        char c;
        for(int i=0; i<s.length(); i++) {
        	c = s.charAt(i);
        	if(c == '(') {
        		sum++;
        	} else if(c == ')'){
        		if(sum <= 0) {
        			return false;
        		} else {
        			sum --;
        		}
        	}
        }

        return sum == 0;
    }
}