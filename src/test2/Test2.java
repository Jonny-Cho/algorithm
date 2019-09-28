package test2;

public class Test2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new String[] {"D5"})); //50
		System.out.println(s.solution(new String[] {"D5", "E8", "G2"})); //42
	}

}

class Solution {
    public int solution(String[] bishops) {
        int answer = 0;
        
        // D5를 체스판 위치로 변경
        int [][] positions = new int[bishops.length][2];
        for(int i=0; i<bishops.length; i++) {
        	positions[i][0] = bishops[i].charAt(0)-'A';
        	positions[i][1] = bishops[i].charAt(1)-'1';
        }
        
        // 체크를 위한 boolean 이차원 배열 만들기
        boolean[][] board = new boolean[8][8];
        
        for(int k=0; k<positions.length; k++) {
        	int x = positions[k][0];
        	int y = positions[k][1];
        	for(int i=0; i<board.length; i++) {
        		for(int j=0; j<board[0].length; j++) {
        			// 비숍이 갈 수 있는 곳 판단
        			if(Math.abs(x - i) == Math.abs(y - j)) {
        				board[i][j] = true;
        			}
        		}
        	}
        }
        
        // boolean 배열의 false 카운트
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(board[i][j] == false) answer++;
        	}
        }
        return answer;
    }

}
