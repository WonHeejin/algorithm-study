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
