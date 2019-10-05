package baekjoon3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answerCount = 0;
		int n = sc.nextInt();
		String str;
		
		for(int i=0; i<n; i++) {
			str = sc.next();
			if(isGoodWord(str)) answerCount++;
		}
		
		System.out.println(answerCount);
		
		sc.close();
	}

	private static boolean isGoodWord(String str) {
		Stack<Character> ll = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(!ll.isEmpty() && ll.peek() == str.charAt(i)) {
				ll.pop();
			} else {
				ll.push(str.charAt(i));
			}
		}
		
		return ll.size() == 0;
	}

}
