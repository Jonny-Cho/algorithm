package biggestnumber;

public class BiggestNumber {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {6, 10, 2})); // "6210"
		System.out.println(s.solution(new int[] {3, 30, 301, 34, 35})); // "3534330301"
		System.out.println(s.solution(new int[] {0, 0, 0})); // "0"
		System.out.println(s.solution(new int[] {12, 121})); // "12121"
		System.out.println(s.solution(new int[] {21, 212})); // "21221"
		System.out.println(s.solution(new int[] {1, 12})); // "121"
	}

}

class Solution{
	
	public String solution(int[] numArr) {
		String answer = "";
		
		quickSort(numArr);

		StringBuilder sb = new StringBuilder();
		for(int i : numArr) {
			sb.append(String.valueOf(i));
		}
		answer = sb.toString();
		
		if(answer.charAt(0) == '0') {
			return "0";
		}
		
		return answer;
	}
	
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if(start < part2 - 1) quickSort(arr, start, part2 - 1);
		if(part2 < end) quickSort(arr, part2, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		while(start <= end) {
			while(customSort(arr[start], pivot)) {
				start++;
			}
			while(customSort(pivot, arr[end])) {
				end--;
			}
			if(start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static boolean customSort(int arrStart, int pivot) {
		String strA = String.valueOf(arrStart);
		String strB = String.valueOf(pivot);
		
		return Integer.parseInt(strA + strB) > Integer.parseInt(strB + strA);
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	
}
