import java.io.*;
import java.util.*;

public class Main{

	public static boolean[] visited;
	public static int[] result;
	public static int r;
	public static int n;
	public static int[] intArrN;
	public static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		intArrN = new int[n];
		visited = new boolean[n];
		result  = new int[r];
		for(int i=1; i<=n; i++) {
			intArrN[i-1] = i;
		}
		permutation(0);
        System.out.println(sb.toString());
	}
	
	public static void permutation(int depth) {
		if(depth == r) {
			Arrays.stream(result).forEach(e -> sb.append(e).append(" "));
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				continue;
			} else {
				result[depth] = intArrN[i];
				visited[i] = true;
				permutation(depth+1);
				visited[i] = false; //r번째까지 다 돌면 visited 초기화 
			}
		}
	}
}