package carpets;

import java.util.Arrays;

public class Carpets {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(8, 1))); // [3, 3]
		System.out.println(Arrays.toString(s.solution(24, 24))); // [8, 6]
	}

}

class Solution {
    public int[] solution(int brown, int red) {
        int[] answer;
        
        int b = ((brown / 2) + 2); // 14
        int c = brown + red; // 48
        
        int discriminant = (int) Math.sqrt((b * b) - (4 * c));
        
        int x = (b + discriminant) / 2;
        int y = (b - discriminant) / 2;
        
        answer = new int[] {x, y};
        
        return answer;
    }
}