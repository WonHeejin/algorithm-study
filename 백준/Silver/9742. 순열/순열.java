import java.io.*;
import java.util.*;

public class Main{

	public static boolean[] visited;
	public static String[] result;
	public static int n;
	public static int count;
	public static int stop;
	public static String[] elements;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = br.readLine()) != null) {
			
			StringTokenizer st = new StringTokenizer(str);
			elements = st.nextToken().split("");
			n = elements.length;
			count = 0;
			stop = Integer.parseInt(st.nextToken());
			visited = new boolean[n];
			result  = new String[n];
			//n개 중에 n개를 뽑는 순열 nPn
			permutation(0);
			
			Arrays.stream(elements).forEach(System.out::print);
			System.out.print(" "+stop+" = ");
			if(count<stop) {
				System.out.println("No permutation");
			} else {
				Arrays.stream(result).forEach(System.out::print);
				System.out.println();
			}
		}
	}
	
	
	/**
	 * 순열의 모든 경우 출력
	 * @param depth
	 */
	public static void permutation(int depth) {
		if(depth == n) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(count == stop) {
				break;
			}
			if(visited[i]) {
				continue;
			} else {
				result[depth] = elements[i];
				visited[i] = true;
				permutation(depth+1);
				visited[i] = false; //r번째까지 다 돌면 visited 초기화 
			}
		}
	}
}