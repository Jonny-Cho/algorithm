package kakao2020bracketconversion;

public class BracketConversion {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("(()())()")); // (()())()
		System.out.println(s.solution("")); // ""
		System.out.println(s.solution(")(")); // ()
		System.out.println(s.solution("()))((()")); // ()(())()
	}

}

class Solution {
    public String solution(String p) {
        if(rightBracket(p)) return p;
        else return convertBracket(p);
    }

	private boolean rightBracket(String p) {
		int tempInt = 0;
		for(int i=0; i<p.length(); i++) {
			if(tempInt < 0) return false;
			if(p.charAt(i) == '(') tempInt++;
			if(p.charAt(i) == ')') tempInt--;
		}
		return true;
	}
	
	private String convertBracket(String p) {
		if ("".equals(p)) return "";

		String u = balancedBracket(p);
		String v = p.substring(u.length());
		
		StringBuilder sb = new StringBuilder();
		if(rightBracket(u)) {
			sb.append(u);
			sb.append(convertBracket(v));
			return sb.toString();
		}
		else {
			sb.append("(");
			sb.append(convertBracket(v));
			sb.append(")");
			sb.append(removeAndReverse(u));
			return sb.toString();
		}
	}

	private String balancedBracket(String w) {
		StringBuilder sb = new StringBuilder();
		int tempInt = 0;
		for(int i=0; i<w.length(); i++) {
			char c = w.charAt(i);
			if(c == '(') tempInt ++;
			if(c == ')') tempInt --;
			sb.append(c);
			if(i >= 1 && tempInt == 0) return sb.toString();
		}
		return sb.toString();
	}
	
	private String removeAndReverse(String u) {
		StringBuilder sb = new StringBuilder();
		String center = u.substring(1, u.length()-1);
		for(int i=0; i<center.length(); i++) {
			if(center.charAt(i) == '(') sb.append(')');
			if(center.charAt(i) == ')') sb.append('(');
		}
		return sb.toString();
	}
}
