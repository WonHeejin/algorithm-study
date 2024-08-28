import java.io.*;
import java.util.*;

public class Main{
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] board = new String[n];
		int result = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			board[i] = br.readLine();
		}
		
		for(int j=0; j<=n-8; j++) {
			for(int k=0; k<=m-8; k++) {
				int count = solution(j, k, board); 
				if(result>= count) {
					result = count;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static int solution(int row, int col, String[] board) {
		//row로 부터 8개, col로 부터 8개 수정칸의 최소 개수 리턴
		char[] color = {'B', 'W'};
		int index = 0;
		int count = 0;
		//시작 컬러가 B-> color[0]부터 시작, W-> color[1]부터 시작
		//시작컬러는 변경하지 않아도 된다는 전제
		if(board[row].charAt(col) == 'W') {
			index = 1;
		}
		
		for(int i=row; i<row+8; i++) {
			for(int j=col; j<col+8; j++) {
				if(board[i].charAt(j) != color[index%2]) {
					count++;
				}
				index++;
			}
			index++;
		}
		//count : 시작컬러는 변경 x / 64-count : 시작컬러 변경 o -> 9 23 예제
		return Math.min(count, 64-count);
	}
}