## 플로이드 알고리즘

모든 정점쌍 사이의 최단 거리를 구하는 알고리즘

시간복잡도 O(v^3) 공간복잡도 O(v^2) (v는 정점) v가 1000개정도로 적을때 사용하면 좋다. 구현이 쉬움

음수의 싸이클이 있으면 사용 불가...

- 최단거리 테이블을 갱신하는 것으로 구현하는 알고리즘

  1. 정점의 개수가 n개라면 n*n의 테이블을 만들어주고 자기 자신으로 가는 것은 0으로 그리고 다른 정점을 거치지 않고
 
     바로 옆의 간선의 거리를 각각 적어준다(즉 바로 직관적으로 알수 있는 것들을 적어준다.)

     모르는 것은 무한대로 정의해놓는다.

  3. 임의의 정점부터 시작하여 그 정점을 거쳐갈때의 최단거리를 갱신해 준다.
 
     ex) 정점 s -> 정점 t로 이동할때 거리는 D[s][t]로 저장, 임의의 정점 1부터 시작한다고 하면

     D[s][t]와 D[s][1]+D[1][t]의 거리를 비교해 갱신해준다. 반대로 D[t][1]+D[1][s]도 갱신해준다.

  -> 이 방식은 최단 거리는 알 수 있지만 경로는 알지 못한다.

  so, 경로 복원 방법

  1. 하나의 n*n 배열을 만들어준다.
 
  2. 앞에서 a정점을 지날때 거리의 최소값이 갱신되면 D[s][t]의 값을 D[a][t]의 값으로 변경해준다.


## 다익스트라 알고리즘

- 하나의 시작점으로 부터 다른 모든 정점까지의 최단거리를 구하는 알고리즘(하나의 시작점부터 하나의 끝점까지 구할때도 사용)

  가중치가 음수인 간선이 있으면 사용 불가

- 우선순위 큐를 이용한 다익스트라 알고리즘 구현(거리 확정되어있는지 확인  x)
  1.  우선순위 큐에 (0,시작점)을 추가
  2.  우선순위 큐에서 거리가 가장 작은 원소를 선택, 해당 거리가 최단거리 테이블과 다를 경우 넘어감
  3.  원소를 가르키는 정점을 v라고 할때, v와 이웃한 정점들에 대해 최단거리 테이블 값보다 v를 거쳐가는 것이 더 작은 값을 가질경우 최단거리 테이블의 값을 갱신하고 우선순위 큐(거리,이웃한 정점의 번호)에 추가
  4.  큐가 빌 때까지 위과정 반복
 
- 경로 복원 방법

  거리 테이블의 값을 갱신할때 , 어디서 왔는지 나타내는 다른 테이블을 갱신시켜준다.
