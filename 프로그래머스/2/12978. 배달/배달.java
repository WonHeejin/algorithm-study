class Solution {
    public int solution(int N, int[][] road, int K) {
        int inf = 500001; //Integer.MAX_VALUE로 하면 정수 오버플로우 발생, 최대값은 N의 개수 (50) * 간선의 최대 weight (10000) + 1
        int villages[][] = new int[N+1][N+1]; //마을 간 거리를 나타내는 그래프
        int shortest[] = new int[N+1];
        
        //거리 최댓값으로 초기화
        for(int i=0; i<villages.length; i++) {
            for(int j =0; j<villages.length; j++) {
                //자기 자신과의 거리는 0으로 초기화 -> int 배열은 기본값으 0이므로 continue
                if(i == j) {
                    continue;
                }
                villages[i][j] = inf;
            }
        }
        //villages 초기화
        for(int i=0; i<road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int dis = road[i][2];
            //연결하는 도로가 여러 개인 경우 더 가까운 도로 저장
            if(villages[v1][v2] > dis) {
                villages[v1][v2] = dis;
                villages[v2][v1] = dis;
            }
        }

        //1번 마을과의 거리 초기화
        for(int k=2; k<shortest.length; k++) {
            shortest[k] = inf;
        }
        
        
        
        //Dijkstra 실행
        return dijkstra(shortest, villages, K, N);
    }
    
    public int dijkstra(int[] shortest, int[][] villages, int K, int N) {
        int answer = 0;
        int inf = 500001;
        boolean visited[] = new boolean[N+1];
        
        visited[1] = true;
        for(int l=1; l<shortest.length; l++) {
            int vertex = 1;
            int min_value = inf;
            
            //방문하지 않았고 가장 작은 값을 가지는 노드 찾기
            for(int m=2; m<shortest.length; m++) {
                if(!visited[m]&&shortest[m]<min_value) {
                    vertex = m;
                    min_value = shortest[vertex];
                }
            }
            //최종 선택된 노드 방문처리
            visited[vertex] = true;
            //해당 노드를 경유해서 갈 경우로 최단거리 갱신
            for(int n=2; n<=N; n++) {
                if(shortest[n] > shortest[vertex]+villages[vertex][n]) {
                    shortest[n] = shortest[vertex]+villages[vertex][n];
                }
            }
            
        }
        
        //K시간 이하 찾기
        for(int o=1; o<shortest.length; o++) {
            if(shortest[o]<=K) {
                answer++;
            }
        }
        return answer;
    }
    
}