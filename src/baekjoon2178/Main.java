package baekjoon2178;

import java.util.*;

public class Main {
	
	static int[][] mazeArr;
	// 북동남서 순 탐색
	static int[][] aroundArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		// 문제 입력
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		final int M = sc.nextInt();
		
		mazeArr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			char[] chars = str.toCharArray();
			for(int j=0; j<M; j++) {
				mazeArr[i][j] = chars[j] - '0';
			}
		}
		
		System.out.println(Arrays.deepToString(mazeArr));
		sc.close();
		
		bfs(N, M);
	}

	private static void bfs(int n, int m) {
		// 너비 우선 탐색
		// 1. 주변탐색
		// - 범위를 벗어나지 않았는지
		// - 1인지
		// - 출구인지 확인필요
		
		Queue<Square> q = new LinkedList<>();
		
		q.offer(new Square(0, 0));
		mazeArr[0][0] = -1;
		
		// 주변탐색
//		bfs();
	}
	
}

class Square {
	int x;
	int y;
	
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Square [x=" + x + ", y=" + y + "]";
	}
}
