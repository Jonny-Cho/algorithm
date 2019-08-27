package primenumber;

import java.util.ArrayList;
import java.util.List;

public class Primenumber {

	public static void main(String[] args) {
		Solution s = new Solution();
		// 3~50개 이하 배열, 각원소 1~1000 자연수, 중복x
//		System.out.println(s.solution(new int[] {1, 2, 3, 4})); // 1 (1+2+4)
		System.out.println(s.solution(new int[] {1, 2, 7, 6, 4})); // 4 (124, 146, 247, 467)
	}

}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        combination(nums, 3, list);
        
        for(int i : list) {
        	if(checkPrimeNumber(i)) answer ++;
        }
        
        return answer;
    }

	public static boolean checkPrimeNumber(int number) {
		for (int i=2; i<number/2; i++) {
			if(number % i == 0) return false;
		}
		return true;
	}

	public static int combination(int[] arr, int destNum, List<Integer> list) {
		int[] temp = new int[destNum];
		return combination(arr,0,destNum,temp, list);
	}
    
    public static int combination(int[] arr, int curLoc, int destNum, int[] temp, List<Integer> list) {
    	int sum = 0;
    	
		if(destNum==0) {
			for(int i = 0; i < temp.length; i++) {
				sum += arr[temp[i]];
			}
			list.add(sum);
			return sum;
		}

		for(int i = curLoc; i < arr.length; i++) {
			temp[temp.length-destNum] = i;
			combination(arr,i+1,destNum-1, temp, list);
		}
		
		return sum;
	}
    
}