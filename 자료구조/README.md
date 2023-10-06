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

3. 큐

   - Queue의 선언 - Queue<Integer> p = new LinkedList<>();

      linkedlist를 이용한다.

   - Queue의 명령어

       add(), offer() - 값 추가
    
       remove(), poll() - 값 삭제(poll은 값 반환하고 비어있다면  null 반환)
    
       clear() - 초기화
    
       peek() - 첫번째값 참조

    - 주의 할 점 add() 작업은 시간이 오래걸린다. 따라서 값만 뽑아 내는 문제일 때는 arrayList 이용하여 문제를 해결하면 좋다.
