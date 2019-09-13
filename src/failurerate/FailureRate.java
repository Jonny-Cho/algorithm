package failurerate;

import java.util.Arrays;

public class FailureRate {
	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}))); // [3, 4, 2, 1, 5]
		System.out.println(Arrays.toString(s.solution(4, new int[] {4, 4, 4, 4, 4}))); // [4, 1, 2, 3]
	}
}

class Solution{
	int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		double[] failureRateArr = new double[N];
		
		double challengeCount;
		double failureCount;
		
		for(int i=1; i<=N; i++) {
			answer[i-1] = i;
			challengeCount = 0;
			failureCount = 0;
			for(int j=0; j<stages.length; j++) {
				if(stages[j] >= i) challengeCount++;
				if(stages[j] == i) failureCount++;
			}
			failureRateArr[i-1] = failureCount/challengeCount;
		}
		
		descendingSort(failureRateArr, answer);
		
		return answer;
	}

	private void descendingSort(double[] arr, int[] answer) {
        int size = arr.length;
        double temp = 0;
        int temp2 = 0;
        int j = 0;
        for(int i = 1; i < size; i++){
            temp = arr[i];
            temp2 = answer[i];
            for(j=i-1; j>=0 && temp>arr[j]; j--){
                arr[j+1] = arr[j];
                answer[j+1] = answer[j];
            }
            arr[j+1] = temp;
            answer[j+1] = temp2;
        }
	}

}