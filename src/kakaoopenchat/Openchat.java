package kakaoopenchat;

import java.util.Arrays;
import java.util.HashMap;

public class Openchat {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(new String[] 
				{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
		)));
	}

}

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hm = new HashMap<>();
        String[] tmp = new String[3];
        int countAnswerLength = 0;
        for(String s : record){
            tmp = s.split(" ");
            System.out.println(Arrays.toString(tmp));
            if(tmp[0].equals("Enter")) {
            	hm.put(tmp[1], tmp[2]);
            	countAnswerLength++;
            } else if(tmp[0].equals("Change")){
            	hm.put(tmp[1], tmp[2]);
            } else {
            	countAnswerLength++;
            }
        }

        answer = new String[countAnswerLength];
        
        for(int i=0; i<answer.length; i++) {
        	tmp = record[i].split(" ");
        	if(tmp[0].equals("Enter")) {
        		answer[i] = hm.get(tmp[1])+"님이 들어왔습니다.";
        	} else if(tmp[0].equals("Leave")) {
        		answer[i] = hm.get(tmp[1])+"님이 나갔습니다.";
        	}
        }
        
        return answer;
    }
}