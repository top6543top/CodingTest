# 실버 1 11286 절댓값힙

- 문제유형

  우선순위 큐 , heap

- 공부한점

  기존의 힙과 같은 구현방식을 가지는데 힙의 우선순위가 다름으로 swap과 remove함수에 조건만 추가되면된다.

  swap에는 parent와 child의 비교가 remove에는 같은 레벨의 비교가 있으므로 여기에 절댓값이 같을때 값이 작은 값을 고르도록 설정해주면 된다.


  ```java
       PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs =  Math.abs(o1) - Math.abs(o2);

            if (abs == 0) return (int)(o1 - o2);
            else return (int)abs;
        });
  ```

  보기와 같이 우선순위 큐의 람다식을 이용해서 구현하면 간단하다. 사실 속도차이도 크게 나지 않는것 같다.

  람다식의 리턴값에 따라서 우선순위가 달라진다.

  양수-첫번째 매개변수가 더 큰것으로 판단

  0-같은값
  
  음수-첫번째 매개변수가 더 작은것으로 판단
