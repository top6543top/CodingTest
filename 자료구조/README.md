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
