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

## Stack, Queue, DeQue
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
