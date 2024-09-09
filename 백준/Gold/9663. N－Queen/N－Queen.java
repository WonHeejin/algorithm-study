import java.io.*;
import java.util.*;

public class Main{

	public static int[] queens;
	public static int n;
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queens = new int[n];
		dfs(0);
		
		System.out.println(count);
		
	}
	
	public static boolean isVailed(int currRow) {
		//이전 퀸들의 공격범위 안에 있는지 확인
		for(int i=0; i<=currRow-1; i++) {
			//이전 줄 퀸의 세로 공격범위 || 이전 줄 퀸의 대각선 공격범위
			if(queens[i] == queens[currRow] || Math.abs(i-currRow) == Math.abs(queens[i]-queens[currRow])) {
				return false;
			}
			
		}
		return true;
	}
    public static void dfs(int row) {
    	//마지막 row까지 탐색한 경우
    	if(row == n) {
    		count++;
    		return;
    	}
    	
		for(int col=0; col<n; col++) {
			queens[row] = col;
			//row, col에 배치 가능한지 체크
			if(isVailed(row)) {
				//배치 가능하면 다음 row 체크
				dfs(row+1);
			}
		}
	}
    
}