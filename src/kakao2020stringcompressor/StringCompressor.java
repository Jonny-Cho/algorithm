package kakao2020stringcompressor;

import java.util.ArrayList;
import java.util.List;

public class StringCompressor {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("aabbaccc")); // 7
		System.out.println(s.solution("ababcdcdababcdcd")); // 9
		System.out.println(s.solution("abcabcdede")); // 8
		System.out.println(s.solution("abcabcabcabcdededededede")); // 14
		System.out.println(s.solution("xababcdcdababcdcd")); // 17
	}

}

class Solution {
	public int solution(String s) {
		int answer = s.length();
		
		if (answer <= 2) return answer;
		else {
			for(int i=1; i<=s.length()/2; i++) {
				// 3. 결과값이 가장짧은 것을 return
				answer = Math.min(answer, compressor(s, i));
			}
			return answer;
		}
	}

	private int compressor(String str, int num) {
		List<String> strList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int count = 1;

		// 1. n으로 자르고 list에 담기
		for(int i=0; i<str.length(); i+=num) {
			if(i+num <= str.length()) strList.add(str.substring(i, i+num));
			else {
				strList.add(str.substring(i));
			}
		}
		
		// 2. list 순회하면서 앞문자열과 현재문자열 비교
		for(int i=1; i<strList.size(); i++) {
			// 2-1 같으면 cnt++;
			if(strList.get(i).equals(strList.get(i-1))) {
				count++;
				if(i == strList.size()-1) {
					sb.append(count);
					sb.append(strList.get(i-1));
				}
			}
			// 2-2 다르면 cnt+앞의문자열 출력
			else {
				if(count > 1) {
					sb.append(count);
				}
				sb.append(strList.get(i-1));
				count = 1;
				
				if(i == strList.size()-1) {
					sb.append(strList.get(i));
				}
			}
		}
		
		return sb.toString().length();
	}
}