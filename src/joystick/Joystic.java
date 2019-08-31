package joystick;

public class Joystic {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("JEROEN")); // 56
		System.out.println(s.solution("BBBBBB")); // 6+5=11
		System.out.println(s.solution("JAN")); // 23
		System.out.println(s.solution("JAAJB")); // 21
		System.out.println(s.solution("JJAABB")); // 24
		System.out.println(s.solution("AAABAAA")); //4
		System.out.println(s.solution("AAABBAAA")); //6
		System.out.println(s.solution("JJBAAA")); // 21
		System.out.println(s.solution("AABBAAABAAA")); // 10
	}

}

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int[] arr = nameToArray(name);
        
        int start = startIndex(arr);
        int end = endIndex(arr);
        int beforeZero = beforeZero(arr, start, end);
        int afterZero = afterZero(arr, start, end);
        
        int way = shorterWay(arr, start, end, beforeZero, afterZero);
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        
        answer += way;
        return answer;
    }

	private int[] nameToArray(String name) {
		int[] arr = new int[name.length()];
		for(int i=0; i<name.length(); i++) {
			arr[i] = name.charAt(i) - 'A';
			if(arr[i] > 13) {
				arr[i] = arr[i] - (2 * (arr[i] - 13));
			}
		}
		return arr;
	}
	
	private int startIndex(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) return i;
		}
		return 0;
	}
	
	private int endIndex(int[] arr) {
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i] > 0) return i;
		}
		return arr.length-1;
	}
	
	private int beforeZero(int[] arr, int start, int end) {
		
		for(int i=start; i<end; i++) {
			if(arr[i] == 0) {
				return i-1;
			}
		}
		return -1;
	}
	
	private int afterZero(int[] arr, int start, int end) {
		for(int i=start; i<=end; i++) {
			if(arr[i] == 0) {
				for(int j=i; j<=end; j++) {
					if(arr[j] != 0) {
						return j+1;
					}
				}
			}
		}
		return -1;
	}
	
	private int shorterWay(int[] arr, int start, int end, int beforeZero, int afterZero) {
		if(beforeZero == -1 || afterZero == -1) {
			return end;
		}else {
			return Math.min(end, (2*beforeZero+arr.length-afterZero)+1);
		}
	}
}