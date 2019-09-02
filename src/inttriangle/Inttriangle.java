package inttriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Inttriangle {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})); // 30
	}

}

//class Solution {
//    public int solution(int[][] triangle) {
//        int answer = 0;
//        
//        List<Integer> list = new ArrayList<>();
//        
//        getMaxSum(triangle, list);
//        
//        answer = Collections.max(list);
//        
//        return answer;
//    }
//
//	private int getMaxSum(int[][] triangle, List<Integer> list) {
//		int maxSum = 0;
//		return getMaxSum(triangle, 0, 0, maxSum, list);
//	}
//
//	private int getMaxSum(int[][] triangle, int indexX, int indexY, int maxSum, List<Integer> list) {
//		
//		if(indexX == triangle.length) {
//			return maxSum;
//		} else {
//			maxSum += triangle[indexX][indexY];
//			list.add(maxSum);
//			
//			getMaxSum(triangle, indexX+1, indexY, maxSum, list);
//			getMaxSum(triangle, indexX+1, indexY+1, maxSum, list);
//		}
//		
//		return maxSum;
//	}
//}

class Solution{
	public int solution(int[][] triangle) {
	    // 1. 기본값 초기화  //
	    int[][] dp = new int[triangle.length][triangle.length];
	    dp[0][0] = triangle[0][0];
	    for(int i = 1; i < triangle.length; i++) {
	       dp[i][0] = dp[i - 1][0] + triangle[i][0]; 
	       dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
	    }

	    System.out.println(Arrays.deepToString(dp));
	    
//	    System.out.println(Arrays.deepToString(triangle));
	     
	    // 2. 동적계획법 //
	    for(int i = 2; i < triangle.length; i++) 
	       for(int j = 1; j < i; j++) 
	          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
	     
	    System.out.println(Arrays.deepToString(dp));
	    
	    // 3. 최대값 반환 //
	    int max = 0;
	    for(int i = 0; i < dp.length; i++) 
	       max = Math.max(max, dp[dp.length - 1][i]);
	   
	    System.out.println("max = " + max);
	    
	  return max;
	}	
}
