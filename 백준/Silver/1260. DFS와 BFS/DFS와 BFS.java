import java.io.*;
import java.util.*;

public class Main{

	static boolean visited[];
	static int graph[][]; 
	static int nodes;
	static int edges;
	static StringBuffer sb;
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodes = Integer.parseInt(st.nextToken());
		edges = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		visited = new boolean[nodes+1];
		graph = new int[nodes+1][nodes+1];
		sb = new StringBuffer();
		
		for(int i=0; i<edges; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st2.nextToken());
			int node2 = Integer.parseInt(st2.nextToken());
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		
		visited[start] = true;
		sb.append(start).append(" ");
        //dfs
        dfs(start);
        System.out.println(sb.toString());
		
        sb.delete(0, sb.length());
        
        //visited 초기화
        visited = new boolean[nodes+1];
        //bfs
        visited[start] = true;
		sb.append(start).append(" ");
        queue.add(start);
		
		while(!queue.isEmpty()) {
			//큐에서 값을 꺼내서 탐색
			bfs(queue.poll());
		}
		
		System.out.println(sb.toString());
		
	}
    public static void dfs(int current) {
		for(int j=1; j<=nodes; j++) {
			//인접 노드 확인
			if(graph[current][j] == 1) {
				//방문 여부 확인
				if(!visited[j]) {
					visited[j] = true;
					sb.append(j).append(" ");
					//인접 노드 방문
					dfs(j);
				}
			}
		}
	}
    
	public static void bfs(int current) {
		for(int j=1; j<=nodes; j++) {
			//인접 노드 확인
			if(graph[current][j] == 1) {
				//방문 여부 확인
				if(!visited[j]) {
					//큐에 저장 후 방문 처리
					queue.add(j);
					visited[j] = true;
					
					sb.append(j).append(" ");
				}
			}
		}
	}
}