package test3;

public class Test3 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {12, 12, 12, 12, 12})); //36
		System.out.println(s.solution(new int[] {12, 80, 14, 22, 100})); //180
	}

}

class Solution {
    public int solution(int[] sticker) {
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);
        for(int i=2; i<sticker.length; i++) {
        	dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        return dp[sticker.length-1];
    }
}