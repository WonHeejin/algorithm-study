# BeakJoon
알고리즘 스터디를 진행하면서 작성한 코드 \
2022.04.28 \
맞은 문제만 업로드 \
파일명 = 문제번호 \
2024.07.22 \
백준허브 플러그인 연동


# 자료구조

## 리스트
<details>
  <summary><b>배열(Static Array)</b></summary>
  <div markdown="1">
    
  - 고정된 저장공간 -> 선언 시 size 할당 필요.
    ```  
        int[] arr1 = new int[5]; //size가 5인 int형 배열 - 공간만 우선 할당
        int[] arr2 = {1,2,3,4,5}; //size가 5인 int형 배열 - 공간 + 값 할당
    ```  
  - 데이터를 연속적·순차적으로 저장 -> 첫 주소값만 알면 어떤 index에도 바로 접근 가능 -> 시간복잡도 O(1)
    ```
      ex) 첫 주소 = 0X4AF55
      -> 두 번째 데이터 = 0X4AF55 +4*1(byte)
      -> 세 번째 데이터 = 0X4AF55 +4*2(byte)
        ...
      -> n 번째 데이터 = 0X4AF55 +4*(n-1)(byte)
      => 시간복잡도 O(1)
     ```
  - LinkedList의 경우 탐색 시 시간복잡도가 O(n). 따라서 데이터 갯수가 정해져 있다면 배열을 사용하는 것이 효율적.
  - 하지만 데이터 갯수가 정해져 있지 않아 매번 크기가 큰 배열을 선언해야 한다면 메모리 비효율 발생 + 선언 시 정한 size 보다 더 많은 데이터가 저장돼야 하면 에러 발생 => `동적배열` 사용

  </div>
</details>

<details>
  <summary><b>동적 배열(Dynamic Array)</b></summary>
  <div markdown="1">
    
  - 유동적으로 배열 크기 조정.
  - 기존에 할당된 size를 초과하면 size를 2배로 늘린 배열을 새로 선언(doubling)하고 새로운 배열에 데이터 이동, 이후 기존 배열을 삭제함. (resize)
  - java에서는 `ArrayList`로 구현됨.
  - `add(E element)` : 시간복잡도가 배열 크기를 늘려야 하는 경우엔 O(n), 아닌 경우엔 O(1). 아닌 경우가 더 많기 때문에 평균적으로 O(1)
  - `add(int index, E element)` : 인자로 넘겨지는 인덱스 뒤의 데이터를 우측으로 한 칸 씩 이동시킴 -> 시간복잡도 O(n)
  - `remove(int index), remove(E element)` : 해당되는 데이터 찾아서 제거 후 뒤의 데이터를 좌측으로 한 칸 씩 이동시킴 -> 시간복잡도 O(n)
  - `indexOf(Object o)` : 배열 전체 순회 -> 시간복잡도 O(n)
    ``` java
      List<String> list = new ArrayList<String>();
      //get at 시간복잡도 : O(1)
      list.get(1);
      
      //insert back 시간복잡도 :amortized O(1)
      list.add("end");
      
      //insert at 시간복잡도 : O(n) 
      list.add(0, "add");
      
      //remove at 시간복잡도 : O(n)
      list.remove(0);
      list.remove("add");
      
      //search by value 시간복잡도 : O(n)
      list.indexOf("add"); //null일 경우 return -1 
    ```
  </div>
</details>

<details>
  <summary><b>연결 리스트(Linked List)</b></summary>
  <div markdown="1">

  - 'Node'라는 구조체가 연결되는 형식으로 데이터를 저장. '포인터'를 통해 각각의 노드에 접근함.
  - 'Node' : 값(data)와 이전, 다음 노드를 가리키는 '포인터'로 구성됨.
  - '이전 포인터(prev)' : 이전 노드를 가리키는 포인터. 첫 번째 노드(head)의 경우 null 값을 가짐.
  - '다음 포인터(next)' : 다음 노드를 가리키는 포인터. 마지막 노드의 경우 null 값을 가짐.
  - 다음 노드를 가리키는 포인터가 하나만 있는 경우를 Singly Linked List, 이전과 다음 노드 모두 있는 경우는 Doubly Linked List라고 함.
  - java의 Linked List는 Doubly Linked List로 구현되어있음.
  - 배열과 달리 메모리 상에서 연속적으로 저장되지 않기 때문에 사용에 좀 더 자유로움.
  - 메모리상에서는 비연속적이지만, 자료의 주소값을 통해 순차적으로 접근 가능함.
    ```java
     LinkedList<String> linkedList = new LinkedList<String>();
        
      /*데이터 삽입*/
      
      //insert first 시간복잡도 : O(1)
      linkedList.addFirst("first"); //deque
      
      //insert last 시간복잡도 : O(1)
      linkedList.addLast("last"); //deque
      
      //insert at 시간복잡도 : O(n)
      linkedList.add(1, "mid"); //list
      
      //insert last return boolean 시간복잡도 : O(1)
      linkedList.offer("offer1"); //deque, queue
      linkedList.offerLast("last"); //deque

      /*데이터 조회*/
      //get first 시간복잡도 : O(1)
      linkedList.getFirst(); //deque
      //get last 시간복잡도 : O(1)
      linkedList.getLast(); //deque
      //get at 시간복잡도 : O(n)
      linkedList.get(2); //list
      
      /*데이터 삭제*/
      //remove first 시간복잡도 : O(1) 
      linkedList.remove(); //deque, queue
      linkedList.removeFirst(); //deque
      
      //remove last 시간복잡도 : O(1)
      linkedList.removeLast(); //deque
      
      //remove at 시간복잡도 : O(n)
      linkedList.remove(1); //list
      
      /*데이터 수정*/
      linkedList.set(1, "set");
    ````
   
  </div>
</details>

<details>
  <summary><b>시간복잡도 비교</b></summary>
  <div markdown="1">

  |action|Static Array|Dynamic Array|Linked List|
  |---|---|---|---|
  |access|O(1)|O(1)|O(n)|
  |getFirst/getLast|-|-|O(1)|
  |update|O(1)|O(1)|O(n)|
  |insert back|O(1)|amortized O(1)|O(n)-Singly \| O(1)-Doubly|
  |insert front|-|O(n)|O(1)|
  |insert at|O(n)|O(n)|O(n)|
  |remove back|O(1)|O(1)|O(n)-Singly \| O(1)-Doubly|
  |remove front|-|O(n)|O(1)|
  |remove at|O(n)|O(n)|O(n)|
  
  </div>
</details>

## Stack, Queue, DeQue, Qriority Queue
<details>
  <summary><b>스택(Stack)</b></summary>
  <div markdown="1">
    
  - 나중에 저장된 것을 먼저 꺼냄 -> 후입선출(LIFO)
  - 매소드
    |type|method|설명|
    |---|---|---|
    |boolean|empty()|Stack이 피어있는지 확인|
    |Object|peek()|맨 위에 저장된 객체 반환(반환 후 삭제x, 비어있으면 EmptyStackException 발생)|
    |Object|pop()|맨 위에 저장된 객체 반환(반환 후 삭제o, 비버있으면 EmptyStackException 발생)|
    |Object|push()|객체 저장|
    |int|search(Object o)|객체를 찾아서 위치 전달. 없으면 -1 전달(배열과 달리 인덱스 1부터 시작)|
  - 예시
    ```java
    import java.util.Stack;
    
    public class Main {
        public static void main(String[] args) {
    		
    		Stack<Integer> stack = new Stack<Integer>();
                      // 인덱스 
    		stack.push(1); //5
    		stack.push(2); //4 
    		stack.push(3); //3 
    		stack.push(4); //2 
    		stack.push(5); //1
    		
    		System.out.println(stack.search(4)); // 결과 : 2
    		System.out.println(stack.peek()); // 결과 : 5
    		System.out.println(stack.pop()); // 결과 : 5
    		System.out.println(stack.peek()); // 결과 : 4
    ```
  </div>
</details>

<details>
  <summary><b>큐(Queue)</b></summary>

  <div markdown="1">

  - 먼저 저장한 것을 먼저 꺼냄 -> 선입선출(FIFO)
  - 메소드
    |type|method|설명|
    |---|---|---|
    |boolean|add(Object o)|객체 저장(저장공간 부족하면 IllegalStateException 발생)|
    |Object|remove()|객체 반환 후 삭제o(Queue가 비어있으면 NoSuchElementException 발생)|
    |Object|element()|객체 반환 후 삭제x(Queue가 비어있으면 NoSuchElementException 발생)|
    |boolean|offer(Object o)|객체 저장(저장공간 부족하면 false 반환)|
    |Object|poll()|객체 반환 후 삭제o(Queue가 비어있으면 null 반환)|
    |Object|peek()|겍체 반환 후 삭제x(Queue가 비어있으면 null 반환)|
  - 예시
    ```java
     import java.util.Queue;
    
    public class Main {
      public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
  
        System.out.println(queue.element()); //결과 : 1
        System.out.println(queue.remove()); //결과 : 1
        System.out.println(queue.element()); //결과 : 2
        System.out.println(queue.remove()); //결과 : 2
        System.out.println(queue.remove()); //결과 : 3
        System.out.println(queue.element()); //결과 : 4 
    ```    
  </div>
</details>

<details>
  <summary><b>덱(Deque)</b></summary>

  <div markdown="1">

  - 양쪽에서 추가,삭제 가능한 양방향 큐(Double-Ended Queue)
  - Queue를 상속받아 구현되며, Java에서는 ArrayDeque, LinkedList 등으로 구현됨
  - Stack 대신 Deque를 사용해야 하는 이유 : Stack은 Vector 클래스를 상속받아 구현됨. Vector는 동기화된 메서드로 구현되어있어 멀티 스레드 환경에서는 안전하지만 단일 스레드 환경에서는 동기화 차리에 대한 오버헤드가 발생하면서 성능이 저하됨. 이로인해 Vector 사용이 권장되지 않고 Vector를 상속받는 Stack 또한 권장되지 않음. 
  - 메소드
    - Stack과 대응되는 매소드 (addLast/addremove 또는 addFirst/removeFirst)
      |Stack|Deque|
      |---|---|
      |push(e)|addFirst(e)|
      |pop()|removeFirst()|
      |peek()|peekFirst()|
    - Queue와 대응되는 메소드
      |Queue|Deque|
      |---|---|
      |add(e)|addLast(e)|
      |offer(e)|offerLast(e)|
      |remove()|removeFirst()|
      |poll()|pollFirst()|
      |element()|getFirst()|
      |peek()|peekFirst()|

  </div>
</details>

<details>
  <summary><b>우선순위 큐(Priority Queue)</b></summary>

  <div markdown="1">
    
  - 들어오는 순서에 상관 없이 우선순위가 높은 데이터가 먼저 나가는 자료구조
  - `힙(Heap)`을 이용하여 구현하는 것이 가장 효율적
  - 배열 vs 힙 시간복잡도 비교
    ||배열|힙|
    |---|---|---|
    |원소 추가|O(1)|O(logN)|
    |우선순위 가장 높은 원소 확인|O(N)|O(1)|
    |우선순위 가장 높은 원소 제거|O(N)|O(logN)|
  - `힙(Heap)` : 우선순위큐를 위해 고안된 `완전이진트리` 형태의 자료구조
  - `완전이진트리` : 두 개의 자식 노드만 갖는 이진트리. 마지막 레벨을 제외한 모든 레벨이 채워져 있고, 마지막 레벨은 왼쪽부터 채워져야함.
  - 힙의 종류
    - 최대 힙(Max Heap) : 부모 노드의 값이 자식 노드보다 크거나 같음. 가장 위의 노드가 최댓값.
    - 최소 힙(Min Heap) : 부모 노드의 값이 자식 노드보다 작거나 같음. 가장 위의 노드가 최솟값.
  - 힙을 배열로 표현했을 때의 인덱스
    - 왼쪽 자식 노드 : 부모 노드 *2
    - 오른쪽 자식 노드 : 부모 노드*2+1
    - 부모 노드 : 자식 노드/2

  - 노드 삽입
    - 마지막 레벨의 왼쪽 부터 삽입. 삽입 후 부모 노드와 비교 후 우선순위에 따라 노드 변경.
      ``` java
      //Min Heap
      ArrayList<Integer> heap = new ArrayList<Integer>();
      public void insert(int number) {
        int i = heap.size()+1; //마지막 노드의 인덱스
    
        while(i>1 && number < heap.get(i/2)) { //첫번째 노드까지  부모 노드와 비교
          //부모 노드 보다 작으면 부모노드를 자식 노드로, 새로 들어온 노드를 부모노드로 변경
          heap.set(i, heap.get(i/2));
          i/=2; //부모 노드로 이동
        }
        heap.set(i, number);
      }
      ```
  - 노드 삭제
    - 최상위 노드를 삭제하면 트리구조가 깨지기 때문에 젤 마지막 노드와 최상위 노드의 자리를 변경 후 마지막 노드 삭제. 이후 자식 노드와 비교하며 우선순위에 따라 노드 변경.
      ```java
       //Min Heap
      ArrayList<Integer> heap = new ArrayList<Integer>();
      public void delete() {
        int temp = heap.get(heap.size()); //최상위로 올릴 노드
        heap.set(heap.size(), heap.get(1)); //첫번째 노드를 마지막 노드로 이동
        heap.remove(heap.size()); //마지막 노드 삭제
        int parent = 1; //현재 노드
        int child = 2; //자식 노드
        
        while(child<heap.size() && temp < heap.get(child)) { //마지막 노드 까지 자식노드와 비교, 자식 노드보다 작으면 중단
          //왼쪽 노드 보다 오른쪽 노드가 더 작으면 오른쪽 노드로 이동
          if(heap.get(child) > heap.get(child+1)) {
            child++;
          }
          
          //자식 노드와 자리 바꾸고 다음 자식노드와 비교
          heap.set(parent, heap.get(child));
          parent = child;
          child = child*2;
        }
        heap.set(parent, temp);
      }
      ```

    - 자바의 Priority Queue
      ```java
      public static void main(String[] args) throws IOException {
        //오름차순
        PriorityQueue<Integer> asc = new PriorityQueue<Integer>();
      
        asc.add(5);
        asc.add(3);
        asc.add(2);
        asc.add(6);
        asc.add(1);
      
        while(!asc.isEmpty()) {
          System.out.println(asc.poll()); // 출력 : 1 2 3 5 6
        }

        //내림차순
        PriorityQueue<Integer> desc = new PriorityQueue<Integer>(Collections.reverseOrder());
      
        desc.add(5);
        desc.add(3);
        desc.add(2);
        desc.add(6);
        desc.add(1);
      
        while(!desc.isEmpty()) {
          System.out.println(desc.poll()); // 출력 : 6 5 3 2 1
        }

        //람다식을 이용하여 우선순위 변경
        PriorityQueue<Integer> abs = new PriorityQueue<Integer>((o1, o2) -> {
  			if(Math.abs(o1) == Math.abs(o2)) {
  				return o1 - o2; //절댓값이 같으면 더 작은 수 우선
  			} else {
  				return Math.abs(o1) - Math.abs(o2); //절댓값이 작은 순서대로
  			}
  		});
  		
  		abs.add(1);
  		abs.add(-1);
  		abs.add(-2);
  		abs.add(-3);
  		System.out.println("abs:"+abs.poll()); // 출력 : -1
      }
      ```
  </div>
</details>

## DFS, BFS
<details>
  <summary><b>깊이 우선 탐색(Depth First Search)</b></summary>

  <div markdown="1">

  - 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
  - 동작 과정
    1. 첫 번째 노드 방문
    2. 인접 노드 유무 확인
    3. 인접 노드 존재o -> 현재 노드를 스택에 저장 후 방문처리
    4. 인접 노드 존재x -> 스택에서 최상단 노드 꺼내어 해당 노드로 이동
    5. 2~4번 순서 반복하다가 인접 노드가 없고 스택에 저장된 노드도 없으면 탐색 종료

  - 장점
    - 현재 순회 중인 노드만 저장(Stack 활용)하기 때문에 BFS에 비해 메모리 공간을 덜 차지함
    - 목표 노드가 깊은 단계에 있는 경우 해를 빨리 구할 수 있음
  - 단점
    - 해가 없는 경로에 깊이 빠질 수 있음 -> 미리 지정한 임의의 깊이까지만 탐색하고, 목표 노드를 발견하지 못하면 다음 경로를 탐색하도록 설정해야 함
    - 얻은 해가 최단 경로라는 보장은 없음(최적의 해가 아닐 수 있음)
  - java 구현
    ```java
    package demo;
    
    import java.io.*;
    import java.util.*;
    
    public class Main{
    
    	static Deque<Integer> stack = new LinkedList<Integer>();
    	static boolean visited[];
    	static int graph[][]; 
    	static int nodes;
    	static int edges;
    	static StringBuffer sb;
    
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
    		stack.add(start);
    		sb.append(start).append(" ");
    		
    		dfs(start);
    		
    		System.out.println(sb.toString());
    		
    	}
    
    	public static void dfs(int current) {
    		for(int j=1; j<=nodes; j++) {
    			//인접 노드 확인
    			if(graph[current][j] == 1) {
    				//방문 여부 확인
    				if(!visited[j]) {
    					//스택에 저장 후 방문 처리
    					stack.add(j);
    					visited[j] = true;
    					
    					sb.append(j).append(" ");
    					//인접 노드 방문
    					dfs(j);
    				}
    			}
    		}
    	}
    }
    ```
  </div>
</details>

<details>
  <summary><b>너비 우선 탐색(Breath First Search)</b></summary>

  <div markdown="1">
    
  - 그래프에서 가까운 노드부터 우선적으로 탐색하는 알고리즘
  - 큐 자료구조를 이용함
  - 동작과정
    1. 첫번째 노드 방문처리 후 인접 노드를 큐에 저장
    2. 큐에서 값을 꺼내어 방문처리 후 인접 노드 중 방문하지 않은 노드 있다면  큐에 저장.
    3. 큐에서 값을 꺼낼 수 없을 때 까지 2~3번 반복.

  - 장점
    - 최단 경로를 구할 수 있음
  - 단점
    - 경로가 매우 길 경우 탐색해야하는 노드의 수가 증가함으로 메모리 공간을 많이 차지함
    - 해가 존재하지 않는다면 유한 그래프의 경우 모든 그래프를 탐색한 후 실패로 끝남
    - 무한 그래프의 경우 해를 찾지 못하고 끝내지도 못함
  - java 구현
  ```java
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
  		queue.add(start);
  		
  		while(!queue.isEmpty()) {
  			//큐에서 값을 꺼내서 탐색
  			bfs(queue.poll());
  		}
  		
  		System.out.println(sb.toString());
  		
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
  ```
  </div>
</details>

## 순열, 조합
<details>
  <summary><b>순열(Permutation)</b></b></summary>

  <div markdown="1">
    
  - n개의 값 중에서 r개의 값을 <b>순서를 고려하여</b> 선정하는 경우의 수
  - 즉, 순서가 다르면 다른 경우의 수로 봄([a,b]와 [b,a]는 다른 것으로 취급)
  - 경우의 수를 계산할 때는 n!/(n-r)!로 계산 함
  - java 코드
    ```java
    import java.io.*;
    import java.util.*;
    
    public class Main{
    
    	public static boolean[] visited;
    	public static int[] result;
    	public static int r;
    	public static int n;
    	public static int[] intArrN;
    	
    	public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		n = Integer.parseInt(br.readLine());
    		r = Integer.parseInt(br.readLine());
    		String[] arrN = br.readLine().split("");
    		intArrN = new int[n];
    		visited = new boolean[n];
    		result  = new int[r];
    		for(int i=0; i<arrN.length; i++) {
    			intArrN[i] = Integer.parseInt(arrN[i]);
    		}
    		
    		System.out.println(n+"P"+r+"="+permutationCount(n, r));
    		permutation(0);
    	}
    	
    	/**
    	 * 순열 경우의 수
    	 * @param n
    	 * @param r
    	 * @return
    	 */
    	public static int permutationCount(int n, int r) {
    		return factorial(n) / factorial(n-r);
    	}
    	
    	public static int factorial(int number) {
    		if(number == 1 || number == 0) {
    			return 1;
    		}
    		return number*factorial(number-1);
    	}
    	
    	/**
    	 * 순열의 모든 경우 출력
    	 * @param depth
    	 */
    	public static void permutation(int depth) {
    		if(depth == r) {
    			Arrays.stream(result).forEach(System.out::print);
    			System.out.println("");
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
    ```
- 콘솔
  ```
  4 //n 입력 
  2 //r 입력
  1234 //arrN 입력
  4P2=12 // 순열 경우의 수
  12 //순열 출력 시작
  13
  14
  21
  23
  24
  31
  32
  34
  41
  42
  43 //순열 출력 종료
  ```
  </div>
</details>

<details>
  <summary><b>조합(Combination)</b></summary>

  <div markdown="1">

  - n개의 값 중에서 r개의 값을 <b>순서를 고려하지 않고</b> 선정하는 경우의 수
  - 즉, 순서가 달라도 같은 경우의 수로 봄([a,b]와 [b,a]는 같은 것으로 취급)
  - 경우의 수를 계산할 때는 n!/((n-r)!*r!)로 계산하고 nCr로 표기함
  - java 코드 : `나`를 포함하는 경우의 수(n-1Cr-1)와 `나`를 포함하지 않는 경우의 수(n-1Cr)의 합으로 치환하여 재귀함수 구현
    ```java
    import java.io.*;
    import java.util.*;
    
    public class Main{
    
    	public static boolean[] visited;
    	public static int[] result;
    	public static int r;
    	public static int n;
    	public static int[] intArrN;
    	
    	public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		n = Integer.parseInt(br.readLine());
    		r = Integer.parseInt(br.readLine());
    		String[] arrN = br.readLine().split("");
    		intArrN = new int[n];
    		visited = new boolean[n];
    		result  = new int[r];
    		for(int i=0; i<arrN.length; i++) {
    			intArrN[i] = Integer.parseInt(arrN[i]);
    		}
    		
    		System.out.println(n+"C"+r+"="+combinationCount(n, r));
    		combination(0);
    	}
    	
    	/**
    	 * 조합 경우의 수
    	 * @param n
    	 * @param r
    	 * @return
    	 */
    	public static int combinationCount(int n, int r) {
    		if(n == r || r == 0) {
    			return 1;
    		}
    		return combinationCount(n-1, r-1) + combinationCount(n-1, r);
    	}
    	
    	/**
    	 * 조합의 모든 경우 출력
    	 * @param depth
    	 */
    	public static void combination(int depth) {
    		if(depth == r) {
    			Arrays.stream(result).forEach(System.out::print);
    			System.out.println("");
    			return;
    		}
    		for(int i=depth; i<n; i++) { //depth 이전의 값은 제외
    			if(visited[i]) {
    				continue;
    			} else {
    				result[depth] = intArrN[i];
    				visited[i] = true;
    				combination(depth+1);
    				visited[i] = false; //r번째까지 다 돌면 visited 초기화 
    			}
    		}
    	}
    }
    ```
  - 출력
    ```
    4 //n 입력
    2 //r 입력
    1234 //arrN 입력
    4C2=6 //조합 경우의 수 출력
    12 //조합의 모든 경우의 수 출력 시작
    13
    14
    23
    24
    32
    34
    42
    43 //조합의 모든 경우의 수 출력 종료
    ```
  </div>
</details>

## 정렬(Sort)
<details>
  <summary><b>선택정렬(Selection Sort)</b></summary>

  <div markdown="1">

  - 해당 순서에 원소를 넣을 위치는 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘.
  - 시간복잡도 : O(n²)
  - 예)
    - 오름차순 : 첫 번째 위치에 최솟값, 두 번째 위치에 두 번째 최솟값...
    - 내림차순 : 첫 번째 위치에 최댓값, 두 번째 위치에 두 번째 최솟값...
  - java 코드(오름차순 정렬, 배열 마지막 순서에 최댓값 -> 첫번째 순서에 최솟값)
  ```java
  import java.io.*;
  import java.util.*;
  
  public class Main{
      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());
          int[] arr = new int[N];
          
          //배열에 값 넣기
          StringTokenizer st2 = new StringTokenizer(br.readLine());
          for (int i=0; i<N; i++) {
              arr[i] = Integer.parseInt(st2.nextToken());
          }
          
          solution(N, K, arr);
          
      }
      
      public static void solution(int N, int K, int[] arr) {
          int count = 0;
          int max = 0;
          for(int i=N-1; i>0; i--) {
          	max = i; //최댓값의 인덱스 
          	//최댓값 찾기
              for(int j=i-1; j>=0; j--) {
              	if(arr[j]>arr[max]) {
              		max = j;
              	}
              }
              //배열의 i번째 위치가 최댓값이 아니면 자리 교체
              if(i!=max) {
              	int temp = arr[max];
              	arr[max] = arr[i];
              	arr[i] = temp;
              	++count;
              }
          }
          Arrays.stream(arr).forEach(System.out::print);
      }
  }

  ```
  </div>
</details>

<details>
  <summary><b>거품정렬(Bubble Sort)</b></b></summary>

  <div markdown="1">

  - 서로 인접한 두 원소를 비교하고, 조건에 맞지 않다면 자리를 교환하여 정렬하는 알고리즘
  - java 코드 (오름차순 정렬)
    ```java
    import java.util.*;
    import java.io.*;
    
    public class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            //배열 담기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[0] = Integer.parseInt(st.nextToken());
            }
            
            solution(N, arr);
        }
        
        public static int solution(int N, int[] arr) {
            
            for(int i=0; i<N; i++){
                for(int j=1; j<N; j++) {
                    //두 원소 비교 -> 앞의 원소가 뒤의 원소보다 크면 자리 교체
                    if(arr[j-1]>arr[j]) {
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            
            return count;
        }
    }
    ```
  </div>
</details>

<details>
  <summary><b>삽입정렬(Insertion Sort)</b></summary>

  <div markdown="1">

  - 두 번째 원소부터 시작하여 앞의 원소들과 비교하며 삽입할 위치 지정 -> 원소들을 뒤로 미루고 지정한 위치에 원소 삽입
  - 시간복잡도 : 최선의 경우 O(n) / 평균 또는 최악의 경우 O(n²)
  - java 코드 (오름차순 정렬)
    ```java
    import java.io.*;
    import java.util.*;
    
    public class Main{
        public static void main(String[] args) throws IOException {
            int[] arr = {1,3,5,14,56,37,8,20};
            
            Arrays.stream(solution(arr)).forEach(e -> System.out.print(e+" "));
            
        }
        
        public static int[] solution(int[] arr) {
        	for(int i=1; i<arr.length; i++) { //두 번째 원소부터 시작
        		int temp = arr[i];//현재 원소
        		int prev = i-1;
        		while(prev>=0 && arr[prev]>temp) { //현재 원소가 앞 원소보다 작으면 반복
        			arr[prev+1] = arr[prev]; //앞 원소와 자리 교체
        			prev--; //앞으로 이동
        		}
        		arr[prev+1] = temp; //삽입
        	}
        	return arr;
        }
        
    }
    ```
- 출력
    ```
    1 3 5 8 14 20 37 56 
    ```
    
  </div>
</details>

## Two Pointer, Sliding Window, Binary Search
<details>
  <summary><b>Two Pointer</b></summary>
  <div marks="1">

  - 1차원 배열에서 각기 다른 원소를 가리키는 2개의 포인터를 조작하여 원하는 값을 찾는 알고리즘
  - start/end 또는 left/right 등 2개의 포인터를 조작하고 기록한다.
  - 동작 과정
    - start와 end가 첫번째 원소의 인덱스를 가리키도록 함
    - 현재 가리키는 원소의 합이 구하고자 하는 값보다 작으면 end+1
    - 현재 가리키는 원소의 합이 구하고자 하는 값보다 크면 start+1
    - 현재 가리키는 원소의 합이 구하고자 하는 값과 같으면 result+1
    - 모든 경우ㅇ가 확인될 때 까지 위의 과정을 반복함
  - 시간복잡도 : O(n)
  </div>
</details>

<details>
  <summary><b>Sliding Window</b></summary>
  <div marks="1">

  - 1차원 배열에서 고정 사이즈의 부분배열(윈도우)가 이동하면서 부분배열 내의 데이터를 이용해 문제를 해결하는 알고리즘
  - 동작과정
    - 배열의 길이보다 작은 부분배열 길이 설정
    - 부분배열의 첫번째 원소를 제거하고, 마지막 원소 뒤에 원소를 추가하여 한 칸씩 이동
    - 마지막 원소가 부분배열에 포함될때 까지 반복
  - 시간복잡도 : O(n)
  </div>
</details>

<details>
  <summary><b>Binary Search</b></summary>
  <div marks="1">

  - 정렬된 리스트에서 검색 범위를 좁혀나가며 탐색하는 알고리즘
  - 정렬된 리스트에서만 사용 가능하지만, 검색이 반복될 때 마다 범위가 절반으로 줄어들기 때문에 속도가 빠름
  - 동작 과정
    - 정렬된 배열의 중간값과 탐색할 값을 비교
      - 중간값과 탐색값이 같으면 탐색 종료
      - 중간값보다 탐색값이 크면 중간값의 오른쪽 구간을 탐색
      - 중간값보다 탐색값이 작으면 중간값의 왼쪽 구간을 탐색
    - 값을 찾거나 간격이 비어있을 때 까지 반복
  - 시간복잡도 : 최선 - O(1) / 평균, 최악 - O(log n)
  </div>
</details>

## 유니온 파인드(Union Find)
<details>
  <summary><b>Union Find</b></summary>
  <div markdown="1">

  - 여러 노드 중 2개의 노드를 하나의 집합으로 묶는 union과 특정 노드의 부모 노드를 찾는 find 연산으로 이루어진 알고리즘
  - 두 노드가 같은 그래프에 속하는지 판별하는 알고리즘

    ```java
    import java.util.*;
    
    public class Main{
    	static int[] parents = new int[7];//부모 노드 정보
    
    	public static void main(String args[]) {
    		int[][] graphs = {{1,2}, {1,3}, {4,5}, {4,6}, {5,6}};
    		
    		//부모 노드를 자기 자신으로 초기화
    		for(int i=1; i<=6; i++) {
    			parents[i] = i;
    		}
    		
    		//같은 노드 연결
    		for(int i=0; i<graphs.length; i++) {
    			union(graphs[i][0], graphs[i][1]);
    		}
    		
    		Arrays.stream(parents).forEach(System.out::println); //각 원소의 부모노드 출력
    	}
    	
    	public static void union(int a, int b) {
    		int parentA = find(a);
    		int parentB = find(b);
    		
    		if(parentA != parentB) {
    			parents[b] = parentA;
    		}
    	}
    	
    	public static int find(int a) {
    		//인덱스와 부모 노드가 같으면 그대로 리턴(최상위 노드일 경우)
    		if(parents[a] == a) {
    			return a;
    		} else {
    			//부모 노드를 찾아서 갱신 후 리턴
    			return parents[a] = find(parents[a]);
    		}
    	}
    }
    ```
    
  </div>
</details>

<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0001-two-sum](https://github.com/WonHeejin/algorithm-study/tree/master/0001-two-sum) |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
## Hash Table
|  |
| ------- |
| [0001-two-sum](https://github.com/WonHeejin/algorithm-study/tree/master/0001-two-sum) |
## Linked List
|  |
| ------- |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
## Stack
|  |
| ------- |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
## Design
|  |
| ------- |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
## Doubly-Linked List
|  |
| ------- |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
## Data Stream
|  |
| ------- |
| [1582-design-browser-history](https://github.com/WonHeejin/algorithm-study/tree/master/1582-design-browser-history) |
<!---LeetCode Topics End-->
