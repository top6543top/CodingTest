# <자료구조>


1. 스택

   - Stack의 선언 - Stack<Integer> stack = new Stack<>();

    - Stack의 명령어
      
        push(입력) - 입력
   
        pop() - 맨 위 제거
      
        peek() - 맨 위 값 출력
      
        size() - 크기 출력
      
        empty() - 비어있으면 true 출력
      
        contains(입력) - 입력된 것이 있는지 확인 있다면 true 반환 


---

2. 큐

   - Queue의 선언 - Queue<Integer> p = new LinkedList<>();

      linkedlist를 이용한다.

   - Queue의 명령어

       add(), offer() - 값 추가
    
       remove(), poll() - 값 삭제(poll은 값 반환하고 비어있다면  null 반환)
    
       clear() - 초기화
    
       peek() - 첫번째값 참조

    - 주의 할 점 add() 작업은 시간이 오래걸린다. 따라서 값만 뽑아 내는 문제일 때는 arrayList 이용하여 문제를 해결하면 좋다.

---

3. 덱(Deque)

   - Deque의 선언 - ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 다음과 같은 것으로

     Deque<> dq = new 000<>();

      이용가능

   - Deque의 명령어
  
     addFirst(), offerFirst() - 앞쪽에 값 추가, add는 용량초과 시 오류 발생, offer은 삽입가능시 true, 용량초과시 false

     addLast(){== add()}, offerLast() - 뒤쪽에 값 추가, 위와 동일

     그 외 - size() , contain(),getFirst(),getLast(),peekFirst() ...  과 같은 메소드 존재

     get은 오류 발생, peek은 true,false값 리턴

     add필요 없을 시 List 구현이 더 효율적
---
4. set

   어떠한 원소가 집합에 포함되어있는지를 검사할때, 즉 contains() 작업을 할때 arraylist보다 set이 훨씬 빠르다.

---
5. Heap

   힙은 '최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조'다.

   힙의 키워드는 '빠르게' 이다. 따라서 완전이진트리(마지막 레벨에서 왼쪽부터 채우는 이진 트리)를 이용하여 구현한다.

   이진트리에서 우선순위를 정하는 방법은 각자 정해주는 것이 아니라 부모노드는 항상 우선순위를 가진다이다. 같은 레벨끼리의 우선순위는 고려하지 않는다.

   최대 힙과 최소 힙은 PriorityQueue<Integer> a =new PriorityQueue<>(); -> 최소힙

    PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder()); -> 최대힙

   과 같이 풀 수 있지만 직접 배열이나 linkedlist를 이용하여 구현 가능하다.

   구현 코드는 11279 최대힙2.java 코드를 참고하면 된다.

   우선순위큐 객체를 이용할 때 구현을 할 수도 있는데

   객체 implements Comparable<Restaurant>{
      @Override
       public int compareTo(int a) {
       	
    }
   }


   와 같이 compareTo()를 구현해주면된다.
