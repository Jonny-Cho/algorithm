package phonenumberlist;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(s.solution(new String[] {"119", "97674223", "1195524421"})); // f
		System.out.println(s.solution(new String[] {"123", "456", "789"})); // t
		System.out.println(s.solution(new String[] {"12", "123", "1235", "567", "88"})); // f
	}
	
}

class Solution{
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if(i!=j && phone_book[i].length() <= phone_book[j].length()) {
					if(phone_book[j].startsWith(phone_book[i])) {
						answer = false;
						break;
					}
				} else if(i!=j && phone_book[i].length() > phone_book[j].length()) {
					if(phone_book[i].startsWith(phone_book[j])) {
						answer = false;
						break;
					}
				}
			}
		}
		return answer;
	}
	
}