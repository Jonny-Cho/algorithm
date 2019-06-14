package functiondeploy;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 기능개발
// https://programmers.co.kr/learn/courses/30/lessons/42586
public class FunctionDeploy {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // [2, 1]
		System.out.println(Arrays.toString(s.solution(new int[] {93, 97, 94, 94, 95, 91}, new int[] {1, 1, 1, 1, 1, 1}))); // [5, 1]
		System.out.println(Arrays.toString(s.solution(new int[] {40, 93, 30, 55, 60, 65}, new int[] {60, 1, 30, 5, 10, 7}))); // [1, 2, 3]
		System.out.println(Arrays.toString(s.solution(new int[] {93, 30, 55, 60, 40, 65}, new int[] {1, 30, 5, 10, 60, 7}))); // [2, 4]
		System.out.println(Arrays.toString(s.solution(new int[] {55, 60, 40, 65}, new int[] {5, 10, 60, 7}))); // [4]
	}
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        ArrayList<Integer> al = new ArrayList<>();
        int[] tempArr = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
        	tempArr[i] = (99 - progresses[i]) / speeds[i] + 1;
        }

        System.out.println(Arrays.toString(tempArr));

        for(int i=0; i<tempArr.length; i++) {
        	int count = 1;
        	for(int j=i+1; j<tempArr.length; j++) {
        		if(tempArr[i] >= tempArr[j]) {
        			count++;
        		} else {
        			al.add(count);
        			i = j;
        		}
        	}
        	
        	if(i == tempArr.length - 1) {
        		al.add(count);
        	}
        }
        
//        System.out.println(al);
        
        answer = new int[al.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = al.get(i);
        }
        
        return answer;
    }
}