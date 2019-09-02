package targetnumber;

public class Targetnumber {

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 3)); // 5
		System.out.println(s.solution(new int[] {1, 1, 2}, 4)); // 2
	}

}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = countTargetNumber(numbers, target);
        
        return answer;
    }

	private int countTargetNumber(int[] numbers, int target) {
		return countTargetNumber(numbers, 0, 0, target);
	}

	private int countTargetNumber(int[] numbers, int begin, int sum, int target) {
		if(begin == numbers.length) {
			if(target == sum) {
				return 1;
			} else {
				return 0;
			}
		}
		else {
			return countTargetNumber(numbers, begin+1, sum+numbers[begin] , target) + countTargetNumber(numbers, begin+1, sum-numbers[begin] , target);
		}
	}
}